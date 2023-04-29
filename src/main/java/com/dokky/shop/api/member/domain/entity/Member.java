package com.dokky.shop.api.member.domain.entity;

import com.dokky.shop.api.member.domain.MemberId;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table( name = "TB_MEMBER" )
@Builder( access = AccessLevel.PUBLIC )
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PROTECTED )
@FieldDefaults( level = AccessLevel.PRIVATE )
public @Getter class Member {
    @Id
    MemberId memberId;
    String password;
    String name;
    String email;
    String phoneNo;
    @OneToMany( mappedBy = "member" )
    List<ShippingInfo> shippingInfos;
    @OneToMany( mappedBy = "member" )
    List<PaymentInfo> paymentInfos;
}
