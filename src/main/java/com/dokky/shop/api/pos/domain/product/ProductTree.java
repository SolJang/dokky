package com.dokky.shop.api.pos.domain.product;


import com.dokky.shop.api.pos.Creator;
import com.dokky.shop.api.pos.DomainEventPublisher;
import com.dokky.shop.api.pos.Modifier;
import com.dokky.shop.api.pos.application.product.ProductTreeCreatedEvent;
import com.dokky.shop.api.pos.domain.Hashtag;
import com.dokky.shop.api.pos.domain.ShopId;
import com.dokky.shop.api.pos.domain.category.CategoryId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table( name = "TB_PRODUCT_TREE" )
@NoArgsConstructor( access = PROTECTED )
@AllArgsConstructor( access = PRIVATE )
@FieldDefaults( level = PRIVATE )
@Builder( access = PRIVATE )
public @Getter class ProductTree {

    @EmbeddedId
    ProductTreeId id;

    @Embedded
    @AttributeOverride( name = "value", column = @Column( name = "PARENT_TREE_ID" ) )
    ProductTreeId parentTreeId;

    @Embedded
    ProductId productId;

    @Embedded
    @AttributeOverride( name = "value", column = @Column( name = "PARENT_PRODUCT_ID" ) )
    ProductId parentProductId;

    @Column( name = "SIMPLE_NAME" )
    String name;

    TreeType treeType;

    Integer ordinal;

    Integer amount;
    String dateFrom;

    String dateTo;

    OptionType optionType;

    SelectType selectType;

    @Column( name = "SERVICE_TYPE" )
    int services;

    Integer minQuantity;

    Integer maxQuantity;

    @Column( name = "DISPLAY_FLAG" )
    Boolean displayed;

    @Column( name = "USE_FLAG" )
    Boolean enabled;

    @Embedded
    ProductOptionGroupId optionGroupId;

    @Embedded
    ShopId shopId;

    @Embedded
    Creator creator;

    @Embedded
    Modifier modifier;

    @Transient
    boolean _new;

    @OneToMany( fetch = FetchType.LAZY, cascade = CascadeType.PERSIST )
    @JoinColumn( name = "TAG_USE_KEY" )
    Set< Hashtag > tags;


    public void addTags( Set< Hashtag > tags ) {
        tags.addAll( tags );
    }

    public static ProductTree ofMain( ProductTreeId id, ProductId productId, String name, Integer amount, Integer ordinal, Integer minQuantity, Integer maxQuantity, ShopId shopId ) {

        ProductTree productTree = createTree( id, null, productId, null, name, TreeType.GENERAL, amount, ordinal, null, null,
                null, null, 39, minQuantity, maxQuantity, false, true, null, shopId, null, null );

        return productTree;
    }

    public static ProductTree ofOption( ProductTreeId productTreeId, ProductId productId, ProductTreeId parentTreeId, ProductId parentProductId, String name, Integer amount, Integer ordinal, ProductOptionGroupId productOptionGroupId, ShopId shopId ) {
        ProductTree productTree = createTree( productTreeId, parentTreeId, productId, parentProductId, name, null, amount, ordinal, null, null,
                null, null, 39, null, null, false, true, productOptionGroupId, shopId, null, null );

        return productTree;
    }

    public static ProductTree ofOptionGroup( ProductTreeId id, ProductTreeId parentTreeId, ProductId parentProductId, String name, Integer ordinal, ProductOptionGroupId productOptionGroupId, ShopId shopId ) {
        ProductTree productTree = createTree( id, parentTreeId, null, parentProductId, name, null, null, ordinal, null, null,
                null, null, 39, null, null, false, true, productOptionGroupId, shopId, null, null );

        return productTree;
    }

    private static ProductTree createTree( ProductTreeId id, ProductTreeId parentTreeId, ProductId productId, ProductId parentProductId, String name, TreeType treeType, Integer amount, Integer ordinal, String dateFrom, String dateTo, OptionType optionType, SelectType selectType, int services, Integer minQuantity, Integer maxQuantity, Boolean displayFlag, Boolean enabled, ProductOptionGroupId optionGroupId, ShopId shopId, Creator creator, Modifier modifier ) {
        ProductTree productTree = ProductTree.builder()
                .id( id )
                .parentTreeId( parentTreeId )
                .productId( productId )
                .parentProductId( parentProductId )
                .name( name )
                .treeType( treeType )
                .amount( amount )
                .ordinal( ordinal )
                .dateFrom( dateFrom )
                .dateTo( dateTo )
                .optionType( optionType )
                .selectType( selectType )
                .services( services )
                .minQuantity( minQuantity )
                .maxQuantity( maxQuantity )
                .displayed( displayFlag )
                .enabled( enabled )
                .optionGroupId( optionGroupId )
                .shopId( shopId )
                .creator( creator )
                .modifier( modifier )
                ._new( true )
                .build();

        return productTree;
    }
}
