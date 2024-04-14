package com.dokky.shop.api.pos.domain.category;


import com.dokky.shop.api.pos.Creator;
import com.dokky.shop.api.pos.Modifier;
import com.dokky.shop.api.pos.domain.product.ProductTree;
import com.dokky.shop.api.pos.domain.product.ProductTreeId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table( name = "TB_CATEGORY_MENU" )
@NoArgsConstructor( access = PROTECTED )
@AllArgsConstructor( access = PRIVATE )
@FieldDefaults( level = PRIVATE )
@Builder( access = PRIVATE )
public @Getter class CategoryMenu {

    @EmbeddedId
    CategoryMenuId id;

    Integer ordinal;

    @Column( name = "USE_FLAG" )
    Boolean enabled;

    @Embedded
    Creator creator;

    @Embedded
    Modifier modifier;

    @Transient
    boolean _new;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "CATEGORY_ID", updatable = false, insertable = false )
    Category category;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "MENU_ID", referencedColumnName = "TREE_ID", updatable = false, insertable = false )
    ProductTree productTree;

    public static CategoryMenu of( CategoryMenuId id, ProductTreeId treeId, Integer ordinal ) {
        CategoryMenu categoryMenu = CategoryMenu.builder()
                .id( id )
                .ordinal( ordinal )
                .enabled( true )
                ._new( true )
                .build();
        return categoryMenu;
    }

    public void addCategory(Category category) {
        this.category = category;
    }

    public  void addProductTree(ProductTree productTree) {
        this.productTree = productTree;

    }
}
