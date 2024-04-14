package com.dokky.shop.api.pos.application.product;

import com.dokky.shop.api.pos.domain.ShopId;
import com.dokky.shop.api.pos.domain.product.ProductId;
import com.dokky.shop.api.pos.domain.product.ProductOptionGroupId;

public record OptionCreatedEvent( ProductOptionGroupId optionGroupId,
                                  ProductId id,
                                  ShopId shopId ) {
}
