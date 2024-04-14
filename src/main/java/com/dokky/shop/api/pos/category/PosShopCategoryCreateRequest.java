package com.dokky.shop.api.pos.category;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter @Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PosShopCategoryCreateRequest {

    String posShopId;
    Set< String > categoryIds;
}
