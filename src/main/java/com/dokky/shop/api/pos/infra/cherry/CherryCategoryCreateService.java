package com.dokky.shop.api.pos.infra.cherry;


import com.dokky.shop.api.pos.application.PosType;
import com.dokky.shop.api.pos.application.category.PosCategoryService;
import com.dokky.shop.api.pos.application.category.PosShopCategoryCommand;
import com.dokky.shop.api.pos.domain.ShopId;
import com.dokky.shop.api.pos.domain.category.Category;
import com.dokky.shop.api.pos.domain.category.CategoryCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CherryCategoryCreateService implements PosCategoryService {

    private final CherryApi api;

    private final CategoryCreateService categoryCreateService;

    private final CherryProductCreateService cherryProductCreateService;

    @Override
    public void createPosCategories( PosShopCategoryCommand command, ShopId shopId ) {
        List< CherryCategoryResponse.Category > categories = api.getCategories();


        categories.stream()
                .forEach( category -> {
                    Category entity = categoryCreateService.createdCategory( category.id(), category.name(), category.ordinal(), shopId );

                    List< CherryTitlesResponse.Title > titlesAndProducts = api.getTitlesAndProducts( category.id() );
                    cherryProductCreateService.createProducts( titlesAndProducts, entity.getId(), entity.getName(), shopId );
                } );


    }

    @Override
    public boolean isSupport( PosType posType ) {
        // TODO : cherry로 변경
        return PosType.SOLBI == posType;
    }

}
