package com.dokky.shop.api.order.domain;

import com.dokky.shop.api.order.domain.entity.Order;
import com.dokky.shop.api.order.domain.value.OrderNo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, String> {

//    Optional<Order> findById(OrderNo orderNo);
}
