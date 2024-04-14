package com.dokky.shop.api.pos.application.product;


import com.dokky.shop.api.pos.domain.category.CategoryId;
import com.dokky.shop.api.pos.domain.product.ProductTreeId;

public record ProductTreeCreatedEvent(
        CategoryId categoryId,
        ProductTreeId id,
        Integer ordinal
) {
}
