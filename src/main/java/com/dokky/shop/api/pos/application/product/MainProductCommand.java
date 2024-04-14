package com.dokky.shop.api.pos.application.product;

import com.dokky.shop.api.pos.domain.product.ProductId;
import com.dokky.shop.api.pos.domain.product.ProductTreeId;

public record MainProductCommand(
        ProductId productId,
        ProductTreeId treeId

) {
}
