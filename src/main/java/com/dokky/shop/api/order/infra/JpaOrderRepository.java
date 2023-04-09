package com.dokky.shop.api.order.infra;

import com.dokky.shop.api.order.domain.value.OrderNo;
import com.dokky.shop.api.order.domain.OrderRepository;
import com.dokky.shop.api.order.domain.entity.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

//@Repository
//public class JpaOrderRepository implements OrderRepository {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public Optional<Order> findById(OrderNo id) {
//        Order order = entityManager.find(Order.class, id);
//        if (order == null) {
//            Optional.empty();
//        }
//        return Optional.of(order);
//    }
//}
