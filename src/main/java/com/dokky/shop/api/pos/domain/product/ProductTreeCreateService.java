package com.dokky.shop.api.pos.domain.product;

import com.dokky.shop.api.pos.DomainEventPublisher;
import com.dokky.shop.api.pos.application.product.MainProductCommand;
import com.dokky.shop.api.pos.application.product.ProductTreeCreatedEvent;
import com.dokky.shop.api.pos.domain.ShopId;
import com.dokky.shop.api.pos.domain.category.CategoryId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductTreeCreateService {

    private final ProductTreeRepository repository;

    public Set< ProductTree > createProductTree( ProductId productId, String name, Integer amount, Integer ordinal, Integer minQuantity, Integer maxQuantity, CategoryId categoryId, ShopId shopId ) {
        ProductTree productTree = ProductTree.ofMain( ProductTreeId.of( repository.nextId() ), productId, name, amount, ordinal, minQuantity, maxQuantity, shopId );

        repository.save( productTree );

        Set< ProductTree > trees = new LinkedHashSet<>() {{
            add( productTree );
        }};

        DomainEventPublisher.publish( new ProductTreeCreatedEvent( categoryId, productTree.getId(), ordinal ) );

        return trees;
    }

    public Set< ProductTree > createProductTreeByOption( ProductId productId, String name, Integer amount, Integer ordinal, Integer minQuantity, Integer maxQuantity, OptionGroupCommand optionGroupInfo, MainProductCommand mainProductInfo, ShopId shopId ) {
        ProductTree productTree = ProductTree.ofOption( ProductTreeId.of( repository.nextId() ), productId, optionGroupInfo.treeId(), mainProductInfo.productId(), name, amount, ordinal, optionGroupInfo.optionGroupId(), shopId );

        repository.save( productTree );

        Set< ProductTree > trees = new LinkedHashSet<>() {{
            add( productTree );
        }};



        return trees;
    }
}
