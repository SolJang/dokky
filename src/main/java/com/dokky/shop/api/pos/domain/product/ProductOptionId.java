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
public @Getter class ProductOptionId implements Serializable {

    @Serial
    private static final long serialVersionUID = -8455803100939119022L;

    @Column( name = "PRODUCT_OPTION_ID" )
    long value;


    public static ProductOptionId of( long id ) {
        return new ProductOptionId( id );
    }
}
