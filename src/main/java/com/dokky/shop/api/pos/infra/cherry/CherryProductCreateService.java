package com.dokky.shop.api.pos.infra.cherry;


import com.dokky.shop.api.pos.application.product.MainProductCommand;
import com.dokky.shop.api.pos.domain.ShopId;
import com.dokky.shop.api.pos.domain.category.CategoryId;
import com.dokky.shop.api.pos.domain.product.Product;
import com.dokky.shop.api.pos.domain.product.ProductCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class CherryProductCreateService {

    private final CherryApi api;
    private final ProductCreateService productCreateService;
    private final CherryOptionGroupCreateService cherryOptionGroupCreateService;

    public void createProducts( List< CherryTitlesResponse.Title > titlesAndProducts, CategoryId categoryId, String categoryName, ShopId shopId ) {

        titlesAndProducts.stream()
                .filter( title -> !CollectionUtils.isEmpty( title.products() ) )
                .forEach( title -> {

                    AtomicInteger ordinal = new AtomicInteger();

                    title.products().stream()
                            .forEach( product -> {

                                Product entity = productCreateService.createProduct(
                                        product.id(),
                                        product.name(),
                                        product.amount(),
                                        ordinal.incrementAndGet(),
                                        product.badge(),
                                        product.imageUrl(),
                                        categoryId,
                                        shopId );

                                MainProductCommand mainProductInfo = new MainProductCommand( entity.getId(), entity.getTrees().stream().findFirst().get().getId() );

                                List< CherryProductResponse.OptionGroup > optionGroups = api.getOptionGroups( product.id() );

                                cherryOptionGroupCreateService.createOptionGroups( optionGroups, mainProductInfo, shopId );


                            } );
                } );
    }
}
