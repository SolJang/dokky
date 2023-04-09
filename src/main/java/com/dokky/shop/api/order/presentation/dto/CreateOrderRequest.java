package com.dokky.shop.api.order.presentation.dto;

import com.dokky.shop.api.order.domain.value.PaymentType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
public @Getter
@Setter class CreateOrderRequest {
    String userId;
    String phoneNumber;
    AddressRequest address;
    String requestMessage;
    List<OrderLineRequest> items;
    //    List<String> couponCodes;
//    BigDecimal point;
    PaymentType paymentType;

    @FieldDefaults(level = AccessLevel.PRIVATE)
    @Getter
    @Setter
    public static class OrderLineRequest {
        String productId;
        int quantity;
    }

    @FieldDefaults(level = AccessLevel.PRIVATE)
    @Getter
    @Setter
    public static class AddressRequest {
        String zipCode;
        String base;
        String detail;
    }
}


