package com.dokky.shop.api.order.domain.value;

import com.dokky.shop.api.user.domain.UserId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Embeddable
@FieldDefaults(level = AccessLevel.PRIVATE)
public @Getter class Orderer {

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "id", column = @Column(name = "orderer_id"))
    )
    UserId userId;

    @Column(name = "orderer_name")
    String name;


}
