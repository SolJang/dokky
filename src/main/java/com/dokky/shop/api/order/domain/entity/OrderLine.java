package com.dokky.shop.api.order.domain.entity;

import com.dokky.shop.api.order.domain.value.Money;
import com.dokky.shop.api.product.domain.entity.Product;
import com.dokky.shop.api.product.domain.entity.ProductId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

//@Table(name = "order_lines")
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE)
public @Getter class OrderLine {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    Long id;

    @Embedded
    ProductId productId;
    @Embedded
    @AttributeOverride(name = "money", column = @Column(name = "price"))
    Money price;
    int quantity;
    @Embedded
    @AttributeOverride(name = "money", column = @Column(name = "amounts"))
    Money amounts;


}
