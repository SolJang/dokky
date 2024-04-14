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
public @Getter class ProductImageId implements Serializable {

    @Serial
    private static final long serialVersionUID = 6495157802563564127L;

    @Column( name = "PRODUCT_IMG_NO" )
    String value;

    public static ProductImageId of( String id ) {
        return new ProductImageId( id );
    }


}
