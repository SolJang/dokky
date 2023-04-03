package com.dokky.shop.api.order.application;

import com.dokky.shop.api.order.domain.Address;
import com.dokky.shop.api.order.domain.PaymentType;
import com.dokky.shop.api.order.domain.entity.OrderLine;
import com.dokky.shop.api.user.domain.UserId;

import java.math.BigDecimal;
import java.util.List;

public record CreateOrderCommand(
        UserId userId,
        String phoneNumber,
        Address address,
        String requestMessage,
        List<OrderLineCommand> items,
//        List<String> couponCodes,
//        BigDecimal point,
        PaymentType paymentType
) {
}
