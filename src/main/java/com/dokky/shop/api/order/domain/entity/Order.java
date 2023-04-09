package com.dokky.shop.api.order.domain.entity;

import com.dokky.shop.api.order.domain.value.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "orders")
@Access(AccessType.FIELD)
@FieldDefaults(level = AccessLevel.PRIVATE)
public @Getter class Order {
    @EmbeddedId
    OrderNo no;

    @Embedded
    Orderer orderer;

    @Embedded
    Address shippingAddress;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    OrderState state;
    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "total_count"))
    Money totalCount;

}
