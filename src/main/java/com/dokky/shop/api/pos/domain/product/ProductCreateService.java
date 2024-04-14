package com.dokky.shop.api.pos.domain.product;


import com.dokky.shop.api.pos.DomainEventPublisher;
import com.dokky.shop.api.pos.application.product.MainProductCommand;
import com.dokky.shop.api.pos.application.product.OptionCreatedEvent;
import com.dokky.shop.api.pos.domain.ShopId;
import com.dokky.shop.api.pos.domain.category.CategoryId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductCreateService {

    private final ProductRepository repository;

    private final ProductTreeCreateService productTreeCreateService;


    public Product createProduct( Long posMenuCode, String name, Integer amount, Integer ordinal, String badge, String imageUrl,CategoryId categoryId, ShopId shopId ) {

        Product product = Product.of( ProductId.of( repository.nextId() ), name, amount, posMenuCode, imageUrl, shopId );

        repository.save( product );

        product.addTree( productTreeCreateService.createProductTree( product.getId(), name, ordinal, amount, null, null, categoryId, shopId ) );

        return product;

    }
    public Product createProductByOption( Long posMenuCode, String name, Integer amount, Integer ordinal, OptionGroupCommand optionGroupInfo, MainProductCommand mainProductInfo, ShopId shopId ) {

        Product product = Product.of( ProductId.of( repository.nextId() ), name, amount, posMenuCode, null, shopId );

        repository.save( product );

        product.addTree( productTreeCreateService.createProductTreeByOption(product.getId(), name, amount, ordinal, null, null, optionGroupInfo, mainProductInfo, shopId) );

        DomainEventPublisher.publish( new OptionCreatedEvent( optionGroupInfo.optionGroupId(), product.getId(), shopId ) );

        return product;

    }
}
