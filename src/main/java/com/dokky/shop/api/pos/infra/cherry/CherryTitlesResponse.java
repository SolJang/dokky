package com.dokky.shop.api.pos.infra.cherry;

import java.util.List;

public record CherryTitlesResponse(
        List<Title> titles

) {
    public record Title(
            Long id,
            String name,
            Integer ordinal,
            List< Product > products
    ) {

    }
    public record Product(
            Long id,
            String name,
            Integer amount,
            Integer ordinal,
            String badge,
            String imageUrl
    ) {

    }
}
