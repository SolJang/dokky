package com.dokky.shop.api.product.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public @Getter class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
}
