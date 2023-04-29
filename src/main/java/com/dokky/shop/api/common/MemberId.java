package com.dokky.shop.api.common;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@FieldDefaults( level = AccessLevel.PRIVATE )
public @Getter @Setter class MemberId implements Serializable {
    private String value;
}
