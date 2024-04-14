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
@Table( name = "TB_PRODUCT_OPTION" )
@NoArgsConstructor( access = PROTECTED )
@AllArgsConstructor( access = PRIVATE )
@FieldDefaults( level = PRIVATE )
@Builder( access = PRIVATE )
public @Getter class ProductOption {


    @EmbeddedId
    ProductOptionId id;
    @Embedded
    ProductOptionGroupId productOptionGroupId;
    @Column( name = "DEFAULT_SELECT_FLAG" )
    Boolean defaultSelected;
    Integer ordinal;
    @Column( name = "USE_FLAG" )
    Boolean enabled;
    @Embedded
    Creator creator;
    @Embedded
    Modifier modifier;
    @Transient
    boolean _new;

    @ManyToOne
    @JoinColumn( name = "PRODUCT_ID")
    Product product;

}
