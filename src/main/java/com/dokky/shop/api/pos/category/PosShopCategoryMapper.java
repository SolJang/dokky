package com.dokky.shop.api.pos.category;


import com.dokky.shop.api.pos.application.category.PosShopCategoryCommand;
import org.mapstruct.Mapper;

@Mapper
public interface PosShopCategoryMapper {
    PosShopCategoryCommand map( PosShopCategoryCreateRequest request );
}
