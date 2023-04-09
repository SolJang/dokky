package com.dokky.shop.api.category.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "category")
@FieldDefaults(level = AccessLevel.PRIVATE)
public @Getter class Category {
    @EmbeddedId
    CategoryId categoryId;

}
