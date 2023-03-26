package com.dokky.shop.api.user.domain;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserId {
    final String value;

    public UserId(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("UserId cannot be null");
        }
        this.value = value;
    }
}
