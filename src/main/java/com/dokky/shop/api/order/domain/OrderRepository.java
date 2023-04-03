package com.dokky.shop.api.order.domain;

import com.dokky.shop.api.order.domain.entity.Order;

import java.util.Optional;

public interface OrderRepository {

    Optional<Order> findById(OrderNo orderNo);
}
