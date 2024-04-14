package com.dokky.shop.api.pos.domain.product;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Embeddable
@NoArgsConstructor( access = PROTECTED )
@AllArgsConstructor( access = PRIVATE )
@FieldDefaults( level = PRIVATE )
public @Getter class ProductOptionGroupId implements Serializable {

    @Serial private static final long serialVersionUID = -4981630524666969343L;

    @Column( name = "OPTION_GROUP_CODE" )
    String value;

    public static ProductOptionGroupId of( String id ) {
        return new ProductOptionGroupId( id );
    }

}
