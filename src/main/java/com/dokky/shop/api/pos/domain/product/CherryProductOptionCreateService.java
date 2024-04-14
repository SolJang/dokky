package com.dokky.shop.api.pos.domain.product;

import com.dokky.shop.api.pos.application.product.MainProductCommand;
import com.dokky.shop.api.pos.domain.ShopId;
import com.dokky.shop.api.pos.domain.category.CategoryId;
import com.dokky.shop.api.pos.infra.cherry.CherryProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CherryProductOptionCreateService {
    private final ProductCreateService productCreateService;
    public void createOption( List< CherryProductResponse.OptionGroup.Option > options, OptionGroupCommand optionGroupInfo, MainProductCommand mainProductInfo, ShopId shopId ) {

        options.stream().forEach(
                option -> {
                    productCreateService.createProductByOption( option.id(), option.name(), option.amount(), option.ordinal(),
                            optionGroupInfo, mainProductInfo, shopId );

                }
        );
    }
}
