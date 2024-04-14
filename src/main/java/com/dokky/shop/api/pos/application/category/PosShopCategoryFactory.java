package com.dokky.shop.api.pos.application.category;


import com.dokky.shop.api.pos.application.PosType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PosShopCategoryFactory {

    private final List< PosCategoryService > services;

    public PosCategoryService getService( PosType posType ) {
        for ( PosCategoryService service : services ) {
            if ( service.isSupport( posType ) ) {
                return service;
            }
        }
        return null;
    }
}
