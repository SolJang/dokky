package com.dokky.shop.api.member.domain.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table( name = "TB_SHIPPING_INFO" )
public @Getter class ShippingInfo {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    int shippingNo;
    @ManyToOne
    @JoinColumn( name = "memberId" )
    Member member;
    String shippingName;
    String receiverName;
    String receiverPhoneNo;
    String address;
    String detailAddress;
}
