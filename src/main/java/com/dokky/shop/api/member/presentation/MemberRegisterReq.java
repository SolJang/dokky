package com.dokky.shop.api.member.presentation;

import lombok.Getter;

public @Getter class MemberRegisterReq {
    private String memberId;
    private String password;
    private String confirmPassword;
    private String name;
    private String email;
    private String phoneNo;

    // 배송지 정보
    // 배송지명
    private String shippingName;
    // 수령인
    private String receiverName;
    // 수령인 휴대폰번호
    private String receiverPhoneNo;
    // 주소
    private String address;
    // 상세주소
    private String detailAddress;

    // 결제 수단
    // 결제수단 타입
    private String paymentType;
    // 결제수단명
    private String paymentName;
    // 결제수단 은행
    private String paymentBank;
    // 결제수단 번호
    private String paymentNumber;



}
