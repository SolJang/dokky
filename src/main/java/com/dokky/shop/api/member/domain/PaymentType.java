package com.dokky.shop.api.member.domain;

import lombok.Getter;

/**
 * 결제 수단
 */
public @Getter enum PaymentType {
    // 계좌
    ACCOUNT,
    // 카드
    CARD;
}
