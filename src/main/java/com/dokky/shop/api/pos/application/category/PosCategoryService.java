package com.dokky.shop.api.pos.application.category;


import com.dokky.shop.api.pos.application.PosService;
import com.dokky.shop.api.pos.domain.ShopId;

public interface PosCategoryService extends PosService {
    void createPosCategories( PosShopCategoryCommand command, ShopId shopId );
}
