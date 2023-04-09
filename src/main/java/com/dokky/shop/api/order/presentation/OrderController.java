package com.dokky.shop.api.order.presentation;

import com.dokky.shop.api.order.application.CreateOrderService;
import com.dokky.shop.api.order.application.ReadOrderService;
import com.dokky.shop.api.order.application.UpdateOrderService;
import com.dokky.shop.api.order.domain.value.OrderNo;
import com.dokky.shop.api.order.domain.OrderMapper;
import com.dokky.shop.api.order.presentation.dto.CreateOrderRequest;
import com.dokky.shop.api.order.presentation.dto.UpdateOrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(OrderController.PREFIX)
@RequiredArgsConstructor
public class OrderController {
    public final static String PREFIX = "/api/orders";
    public final CreateOrderService createService;
    public final ReadOrderService readService;
    public final UpdateOrderService updateService;
    public final OrderMapper mapper;

    @PostMapping
    public ResponseEntity createOrder(@RequestBody CreateOrderRequest request) {
        System.out.println(request);
        OrderNo orderNo = createService.registerOrder(mapper.of(request));
        return ResponseEntity.created(URI.create(OrderController.PREFIX + "orderId")).build();
    }
    @GetMapping("/{orderNo}")
    public void readOrder (@PathVariable String orderNo) {

    }

    @PutMapping("/{orderNo}")
    public void updateOrder(@PathVariable String orderNo, @RequestBody UpdateOrderRequest request) {

    }
}
