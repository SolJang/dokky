package com.dokky.shop.api.pos.domain.product;


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

@Entity
@Table( name = "TB_PRODUCT_OPTION_GROUP" )
@NoArgsConstructor( access = PROTECTED )
@AllArgsConstructor( access = PRIVATE )
@FieldDefaults( level = PRIVATE )
@Builder( access = PRIVATE )
public @Getter class ProductOptionGroup {

    @EmbeddedId
    ProductOptionGroupId id;
    String templateName;
    String simpleName;
    OptionType optionType;
    SelectType selectType;
    Integer minQuantity;
    Integer maxQuantity;
    @Embedded
    ShopId shopId;

    String posOptionGroupId;
    @Column( name = "USE_FLAG" )
    Boolean enabled;
    @Embedded
    Creator creator;
    @Embedded
    Modifier modifier;
    @Transient
    boolean _new;


    public static ProductOptionGroup of( ProductOptionGroupId id, Long posOptionGroupId, String name, String type, Integer  minQuantity, Integer maxQuantity, ShopId shopId ) {
        return createOptionGroup( id, String.valueOf( posOptionGroupId ), name, name, null, null, minQuantity, maxQuantity, shopId, true, null, null, true );
    }

    public static ProductOptionGroup createOptionGroup( ProductOptionGroupId id, String posOptionGroupId, String templateName, String simpleName, OptionType optionType, SelectType selectType, Integer minQuantity, Integer maxQuantity, ShopId shopId, Boolean enabled, Creator creator, Modifier modifier, boolean _new ) {
        ProductOptionGroup productOptionGroup = ProductOptionGroup.builder()
                .id( id )
                .posOptionGroupId( posOptionGroupId )
                .templateName( templateName )
                .simpleName( simpleName )
                .optionType( optionType )
                .selectType( selectType )
                .minQuantity( minQuantity )
                .maxQuantity( maxQuantity )
                .shopId( shopId )
                .enabled( enabled )
                .creator( creator )
                .modifier( modifier )
                ._new( _new )
                .build();
        return productOptionGroup;
    }
}
