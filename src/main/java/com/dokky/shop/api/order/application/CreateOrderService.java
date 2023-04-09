package com.dokky.shop.api.order.application;

import com.dokky.shop.api.order.domain.entity.Order;
import com.dokky.shop.api.order.domain.value.Money;
import com.dokky.shop.api.order.domain.value.OrderNo;
import com.dokky.shop.api.order.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateOrderService {

    private final OrderNoService orderNoService;
    private final OrderRepository orderRepository;


    public OrderNo registerOrder(CreateOrderCommand command) {


        System.out.println(command);
        return null;
    }
}
