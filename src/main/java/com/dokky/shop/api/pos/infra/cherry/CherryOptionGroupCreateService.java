package com.dokky.shop.api.pos.infra.cherry;

import com.dokky.shop.api.pos.application.product.MainProductCommand;
import com.dokky.shop.api.pos.domain.ShopId;
import com.dokky.shop.api.pos.domain.category.CategoryId;
import com.dokky.shop.api.pos.domain.product.CherryProductOptionCreateService;
import com.dokky.shop.api.pos.domain.product.OptionGroupCommand;
import com.dokky.shop.api.pos.domain.product.ProductOptionGroupCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CherryOptionGroupCreateService {

    private final ProductOptionGroupCreateService optionGroupCreateService;
    private final CherryProductOptionCreateService cherryProductOptionCreateService;

    public void createOptionGroups( List< CherryProductResponse.OptionGroup > optionGroups, MainProductCommand mainProductInfo, ShopId shopId ) {


        optionGroups.stream()
                .forEach( optionGroup -> {
                    OptionGroupCommand optionGroupInfo = optionGroupCreateService.createOptionGroup( optionGroup.id(), optionGroup.name(), optionGroup.type(), optionGroup.ordinal(), optionGroup.minQuantity(), optionGroup.maxQuantity(), mainProductInfo, shopId );

                    cherryProductOptionCreateService.createOption(optionGroup.options(), optionGroupInfo, mainProductInfo,  shopId);
                } );
    }
}
