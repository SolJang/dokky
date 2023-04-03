package com.dokky.shop.api.order.application;

import com.dokky.shop.api.order.domain.OrderNo;
import com.dokky.shop.api.order.domain.OrderRepository;
import com.dokky.shop.api.order.domain.entity.OrderLine;
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
