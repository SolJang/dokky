package com.dokky.shop.api.pos.domain.category;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE)
public @Getter class CategoryMenuId implements Serializable {

    @Serial private static final long serialVersionUID = 4424188550245531852L;

    @Column(name = "CATEGORY_MENU_ID")
    long value;

    public static CategoryMenuId of( long id ) {
        return new CategoryMenuId( id );
    }
}
