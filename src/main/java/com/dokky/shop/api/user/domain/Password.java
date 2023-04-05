package com.dokky.shop.api.user.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@FieldDefaults(level = AccessLevel.PRIVATE)
public @Getter @Setter class Password {
    @Column(name = "password")
    String value;

    public Password () {
    }

    public Password(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        this.value = value;
    }

}
