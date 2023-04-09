package com.dokky.shop.api.order.application;

import com.dokky.shop.api.order.domain.value.Address;
import com.dokky.shop.api.order.domain.value.PaymentType;
import com.dokky.shop.api.user.domain.UserId;

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
