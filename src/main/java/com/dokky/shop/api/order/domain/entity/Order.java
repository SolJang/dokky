package com.dokky.shop.api.order.domain.entity;

import com.dokky.shop.api.order.domain.Address;
import com.dokky.shop.api.order.domain.OrderNo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Table(name = "orders")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public @Getter class Order {
    @EmbeddedId
    OrderNo orderNo;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    List<OrderLine> orderLines = new ArrayList<>();

    @Embedded
    Address shippingAddress;

    BigDecimal totalCount;

    public void addOrderLine(OrderLine orderLine) {
        if (orderLine.getQuantity() < 1) {
            throw new IllegalArgumentException("상품의 주문 수량은 최소 1개 이상이어야 합니다.");
        }

        boolean isDuplicate = orderLines.stream()
                .anyMatch(line -> line.getProduct().getId().equals(orderLine.getProduct().getId()));

    }
}
