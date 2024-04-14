package com.dokky.shop.api.pos.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;

import static org.springframework.util.StringUtils.hasText;


@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public @Getter class ShopId implements Serializable {

    @Serial
    private static final long serialVersionUID = 8711712224814918941L;

    @Column(name = "SHOP_ID")
    String id;

    public static ShopId of(String id) {
        if ( !hasText( id ) ) {
//            throw new ResourceNotFoundException(ErrorStatus.NOT_FOUND);
        }
        return new ShopId(id);
    }

}
