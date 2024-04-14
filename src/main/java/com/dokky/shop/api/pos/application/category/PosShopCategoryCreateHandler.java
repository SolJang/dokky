package com.dokky.shop.api.pos.application.category;


import com.dokky.shop.api.pos.application.PosType;
import com.dokky.shop.api.pos.domain.ShopId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class PosShopCategoryCreateHandler {

    private final PosShopCategoryFactory factory;
    public void createPosCategories( PosShopCategoryCommand command ) {

        //TODO : 매장 검증 필요
        ShopId shopId = ShopId.of( "S220009775" );

        //TODO : commons - POS_TYPE 추가 필요
        factory.getService( PosType.SOLBI )
                .createPosCategories( command, shopId );

    }
}
