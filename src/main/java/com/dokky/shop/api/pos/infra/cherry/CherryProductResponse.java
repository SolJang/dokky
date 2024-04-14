package com.dokky.shop.api.pos.infra.cherry;

import java.util.List;

public record CherryProductResponse(
        List< OptionGroup > optionGroups

) {

    public record OptionGroup(
            Long id,
            String name,
            String type,
            Integer ordinal,
            Integer minQuantity,
            Integer maxQuantity,
            List< Option > options
    ) {


        public record Option(
                Long id,
                String name,
                Integer amount,
                Boolean selected,
                Integer ordinal
        ) {

        }
    }
}
