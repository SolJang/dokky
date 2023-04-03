package com.dokky.shop.api.product.domain.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public @Getter class ProductId implements Serializable {
    String value;

    public ProductId (String value) {
        if(value == null || value.isEmpty()) {
            throw new IllegalArgumentException("ProductId cannot be null");
        }
        this.value = value;
    }
}
