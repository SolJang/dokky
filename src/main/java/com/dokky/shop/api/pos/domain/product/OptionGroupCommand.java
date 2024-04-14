package com.dokky.shop.api.pos.domain.product;

public record OptionGroupCommand(
        ProductTreeId treeId,
        ProductOptionGroupId optionGroupId

) {
}
