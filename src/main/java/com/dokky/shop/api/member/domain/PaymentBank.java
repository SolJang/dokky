package com.dokky.shop.api.member.domain;

import lombok.Getter;

public @Getter enum PaymentBank {
    WOORI("우리은행", "BK01"),
    KB("국민은행", "BK02"),
    IBK("기업은행", "BK03"),
    SHINHAN( "신한은행", "BK04"),
    HANA("하나은행", "BK05"),
    NH("농협은행", "BK06");

    private String name;
    private String code;

    PaymentBank( String name, String code ) {
        this.name = name;
        this.code = code;
    }

}
