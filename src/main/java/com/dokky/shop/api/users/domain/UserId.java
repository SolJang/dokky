package com.dokky.shop.api.users.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@FieldDefaults(level = AccessLevel.PRIVATE)
public @Getter @Setter class UserId implements Serializable {

    @Column(name = "id")
    String value;

    public UserId() {}
    public UserId(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("UserId cannot be null");
        }
        this.value = value;
    }
}
