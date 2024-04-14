package com.dokky.shop.api.pos.application.category;


import com.dokky.shop.api.pos.application.product.ProductTreeCreatedEvent;
import com.dokky.shop.api.pos.domain.category.*;
import com.dokky.shop.api.pos.domain.product.ProductTree;
import com.dokky.shop.api.pos.domain.product.ProductTreeId;
import com.dokky.shop.api.pos.domain.product.ProductTreeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CategoryMenuOnProductTreeCreatedEventHandler {

    private final CategoryMenuRepository repository;

    private final CategoryRepository categoryRepository;
    private final ProductTreeRepository productTreeRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createCategoryMenu( ProductTreeCreatedEvent event ) {
        CategoryId categoryId = event.categoryId();
        ProductTreeId treeId = event.id();
        Integer ordinal = event.ordinal();

        Optional< Category > byId = categoryRepository.findById( categoryId );
        Optional< ProductTree > byId1 = productTreeRepository.findById( treeId );


        CategoryMenu categoryMenu = CategoryMenu.of( CategoryMenuId.of( categoryId.getValue() ), treeId, ordinal );
        categoryMenu.addCategory( byId.get() );
        categoryMenu.addProductTree( byId1.get() );

        repository.save( categoryMenu );


    }
}
