package com.dokky.shop.api.pos.infra.cherry;

import java.util.List;

public record CherryCategoryResponse(
        List< Category > categories
) {
    public record Category(
            Long id,
            String name,
            Integer ordinal
    ) {
    }
}
