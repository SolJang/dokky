package com.dokky.shop.api.common;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embeddable;

@Embeddable
@FieldDefaults( level = AccessLevel.PRIVATE )
@RequiredArgsConstructor
public @Getter @Setter class Password {
    private String value;
}
