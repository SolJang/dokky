package com.dokky.shop.api.order.domain;

import com.dokky.shop.api.order.application.CreateOrderCommand;
import com.dokky.shop.api.order.presentation.dto.CreateOrderRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "userId", target = "userId.value")
    CreateOrderCommand of(CreateOrderRequest request);
}
