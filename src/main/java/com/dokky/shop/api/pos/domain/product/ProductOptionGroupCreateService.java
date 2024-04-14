package com.dokky.shop.api.pos.domain.product;

import com.dokky.shop.api.pos.application.product.MainProductCommand;
import com.dokky.shop.api.pos.domain.ShopId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductOptionGroupCreateService {

    private final ProductOptionGroupRepository repository;
    private final ProductTreeRepository treeRepository;

    public OptionGroupCommand createOptionGroup( Long posOptionGroupId, String name, String type, Integer minQuantity, Integer maxQuantity, Integer ordinal, MainProductCommand mainProductInfo, ShopId shopId ) {

        ProductOptionGroup optionGroup = ProductOptionGroup.of( ProductOptionGroupId.of( repository.nextId() ), posOptionGroupId, name, type, minQuantity, maxQuantity, shopId );

        repository.save( optionGroup );

        ProductTree optionGroupTree = createOptionGroupTree( name, ordinal, optionGroup.getId(), mainProductInfo, shopId );

        OptionGroupCommand optionGroupCommand = new OptionGroupCommand( optionGroupTree.getId(), optionGroup.getId() );

        return optionGroupCommand;
    }

    public ProductTree createOptionGroupTree( String name, Integer ordinal, ProductOptionGroupId optionGroupId, MainProductCommand mainProductInfo, ShopId shopId ) {

        ProductTree productTree = ProductTree.ofOptionGroup( ProductTreeId.of( treeRepository.nextId() ), mainProductInfo.treeId(), mainProductInfo.productId(), name, ordinal, optionGroupId, shopId );

        treeRepository.save( productTree );

        return productTree;

    }
}
