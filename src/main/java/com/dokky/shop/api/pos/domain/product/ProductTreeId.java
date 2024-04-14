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
public @Getter class ProductTreeId implements Serializable {

    @Serial private static final long serialVersionUID = 7005808123227145902L;

    @Column( name = "TREE_ID" )
    long value;

    public static ProductTreeId of( long id ) {
        return new ProductTreeId( id );
    }
}
