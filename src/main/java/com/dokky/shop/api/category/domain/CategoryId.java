package com.dokky.shop.api.category.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public @Getter class CategoryId implements Serializable {
    @Column(name = "category_id")
    String value;

    public CategoryId(String value) {
        if(value == null || value.isEmpty()) {
            throw new IllegalArgumentException("categoryId cannot be null");
        }
    }
}
