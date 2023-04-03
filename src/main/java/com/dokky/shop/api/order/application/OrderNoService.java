package com.dokky.shop.api.order.application;

import com.dokky.shop.api.order.domain.OrderNo;
import com.dokky.shop.api.user.domain.UserId;
import org.springframework.stereotype.Service;

@Service
public class OrderNoService {

    public OrderNo createOrderNo (UserId userId) {
        if (userId == null) {
            throw new IllegalArgumentException("invalid userId: " + userId);
        }
        return new OrderNo(userId.toString() + "-" + timestamp());
    }

    private String timestamp() {
        return Long.toString(System.currentTimeMillis());
    }

}
