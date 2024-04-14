package com.dokky.shop.api.pos.domain.category;

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
public @Getter class CategoryId implements Serializable {

    @Serial
    private static final long serialVersionUID = -945081434414340655L;

    @Column( name = "CATEGORY_ID" )
    long value;

    public static CategoryId of( long id ) {
        return new CategoryId( id );
    }
}
