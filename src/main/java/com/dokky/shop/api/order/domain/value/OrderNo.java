package com.dokky.shop.api.order.domain.value;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Embeddable
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public @Getter class OrderNo implements Serializable {

    @Column(name = "order_no")
    String value;

    public OrderNo(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("OrderId cannot be null");
        }
        this.value = value;
    }
}
