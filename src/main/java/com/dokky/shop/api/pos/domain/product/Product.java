package com.dokky.shop.api.pos.domain.product;


import com.dokky.shop.api.pos.Creator;
import com.dokky.shop.api.pos.Modifier;
import com.dokky.shop.api.pos.domain.ShopId;
import com.dokky.shop.api.pos.domain.category.CategoryId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table( name = "TB_PRODUCT" )
@NoArgsConstructor( access = PROTECTED )
@AllArgsConstructor( access = PRIVATE )
@FieldDefaults( level = PRIVATE )
@Builder( access = PRIVATE )
public @Getter class Product {

    @EmbeddedId
    ProductId id;
    String posMenuCode;
    String name;
    String simpleName;
    Integer amount;
    String imageUrl;
    @Embedded
    ShopId shopId;
    @Embedded
    Creator creator;
    @Embedded
    Modifier modifier;
    @Transient
    boolean _new;

//    @OneToMany( cascade = CascadeType.PERSIST, fetch = FetchType.LAZY )
//    @JoinColumn( name = "PRODUCT_ID" )
//    Set< ProductImage > images = new LinkedHashSet<>();
//


    @OneToMany( cascade = CascadeType.PERSIST, fetch = FetchType.LAZY )
    @JoinColumn( name = "PRODUCT_ID" )
    Set< ProductTree > trees = new LinkedHashSet<>();


    public void addTree( Set< ProductTree > trees ) {
        this.trees = trees;
    }


    public static Product of( ProductId id, String name, Integer amount, Long posMenuCode, String imageUrl, ShopId shopId ) {
        return createProduct( id, String.valueOf( posMenuCode ), name, name, amount, imageUrl, shopId, null, null );
    }


    public static Product createProduct( ProductId id, String posMenuCode, String name, String simpleName, Integer amount, String imageUrl, ShopId shopId, Creator creator, Modifier modifier ) {
        Product product = Product.builder()
                .id( id )
                .posMenuCode( posMenuCode )
                .name( name )
                .simpleName( simpleName )
                .amount( amount )
                .imageUrl( imageUrl )
                .shopId( shopId )
                .creator( creator )
                .modifier( modifier )
                .build();

        return product;
    }
}
