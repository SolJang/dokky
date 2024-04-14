package com.dokky.shop.api.pos.domain.category;


import com.dokky.shop.api.pos.Creator;
import com.dokky.shop.api.pos.Modifier;
import com.dokky.shop.api.pos.domain.ShopId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;


@Table( name = "TB_CATEGORY" )
@NoArgsConstructor( access = PROTECTED )
@AllArgsConstructor( access = PRIVATE )
@FieldDefaults( level = PRIVATE )
@Builder( access = PRIVATE )
public @Entity @Getter class Category {

    @EmbeddedId
    CategoryId id;
    @Column( name = "CATEGORY_NAME" )
    String name;
    String dateFrom;
    String dateTo;
    Integer ordinal;
    String posCategoryCode;
    @Column( name = "USE_FLAG" )
    Boolean enabled;
    @Column( name = "DISPLAY_FLAG" )
    Boolean displayed;
    @Embedded
    ShopId shopId;
    @Embedded
    Creator creator;
    @Embedded
    Modifier modifier;
    @Transient
    boolean _new;

    public static Category of(CategoryId id, String name, Integer ordinal, Long posCategoryCode, ShopId shopId) {
        return createCategory( id, name, null, null, ordinal, String.valueOf( posCategoryCode ),
                true, false, shopId, null, null );
    }

    private static Category createCategory( CategoryId id, String name, String dateFrom, String dateTo, Integer ordinal, String posCategoryCode, Boolean enabled, Boolean displayed, ShopId shopId,
                                            Creator creator, Modifier modifier) {
        Category category = Category.builder()
                .id( id )
                .name( name )
                .dateFrom( dateFrom )
                .dateTo( dateTo )
                .ordinal( ordinal )
                .posCategoryCode( posCategoryCode )
                .enabled( enabled )
                .displayed( displayed )
                .shopId( shopId )
                .creator( creator )
                .modifier( modifier )
                ._new( true )
                .build();
        return category;
    }
}
