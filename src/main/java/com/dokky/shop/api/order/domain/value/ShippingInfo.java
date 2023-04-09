package com.dokky.shop.api.order.domain.value;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Embeddable
@FieldDefaults(level = AccessLevel.PRIVATE)
public @Getter class ShippingInfo {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "zipCode",
                    column = @Column(name = "shipping_zipcode")),
            @AttributeOverride(name = "base",
                    column = @Column(name = "shipping_addr1")),
            @AttributeOverride(name = "detail",
                    column = @Column(name = "shipping_addr2"))
    })
    Address address;
    @Column(name = "shipping_message")
    String message;
    @Embedded
    Receiver receiver;


}
