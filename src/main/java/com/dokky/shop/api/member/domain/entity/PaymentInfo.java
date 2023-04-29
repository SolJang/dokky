package com.dokky.shop.api.member.domain.entity;

import javax.persistence.*;

@Entity
@Table( name = "TB_PAYMENT_INFO" )
public class PaymentInfo {
    @Id
    int paymentNo;
    @ManyToOne
    @JoinColumn( name = "memberId" )
    Member member;
    String paymentType;
    String paymentName;
    String paymentBank;
    String paymentNumber;
}
