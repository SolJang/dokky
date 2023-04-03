package com.dokky.shop.api.order.application;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public @Getter @Setter class OrderLineCommand {
    String productId;
    int quantity;

}
