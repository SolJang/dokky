package com.dokky.shop.api.order.domain.entity;

import com.dokky.shop.api.order.domain.OrderNo;
import com.dokky.shop.api.product.domain.entity.Product;
import com.dokky.shop.api.product.domain.entity.ProductId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Table(name = "order_items")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public @Getter class OrderLine {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    Order order;

    @ManyToOne
    Product product;

    int quantity;

}
