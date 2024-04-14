package com.dokky.shop.api.pos.domain.product;


import com.dokky.shop.api.pos.Creator;
import com.dokky.shop.api.pos.Modifier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table( name = "TB_PRODUCT_IMG" )
@NoArgsConstructor( access = PROTECTED )
@AllArgsConstructor( access = PRIVATE )
@FieldDefaults( level = PRIVATE )
@Builder( access = PRIVATE )
public @Getter class ProductImage {

    @EmbeddedId
    ProductImageId id;
    @Embedded
    ProductId productId;
    @Column( name = "IMAGE_URL" )
    String path;
    @Column( name = "USE_FLAG" )
    Boolean enabled;
    Integer viewSeq;
    @Embedded
    Creator creator;
    @Embedded
    Modifier modifier;

    //TODO : viewSeq 어떻게?
    public static ProductImage of( ProductImageId id, ProductId productId, String imageUrl ) {
        ProductImage image = ProductImage.builder()
                .id( id )
                .productId( productId )
                .path( imageUrl )
                .enabled( true )
                .build();

        return image;
    }
}
