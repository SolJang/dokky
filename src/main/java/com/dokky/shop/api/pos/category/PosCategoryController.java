package com.dokky.shop.api.pos.category;


import com.dokky.shop.api.pos.application.category.PosShopCategoryCreateHandler;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = PosCategoryController.PREFIX )
@RequiredArgsConstructor
public class PosCategoryController {
    public static final String PREFIX = "/qr/menu/v1/events/categories";

    private final PosShopCategoryMapper mapper = Mappers.getMapper( PosShopCategoryMapper.class );

    private final PosShopCategoryCreateHandler createHandler;

    @PostMapping
    public void createPosCategories( @RequestBody PosShopCategoryCreateRequest request ) {
        createHandler.createPosCategories( mapper.map( request ) );
    }
}
