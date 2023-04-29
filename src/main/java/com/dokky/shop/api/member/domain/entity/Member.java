package com.dokky.shop.api.member.domain.entity;

import com.dokky.shop.api.common.Email;
import com.dokky.shop.api.common.MemberId;
import com.dokky.shop.api.common.Password;
import com.dokky.shop.api.common.PhoneNo;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table( name = "TB_MEMBER" )
@Builder( access = AccessLevel.PUBLIC )
@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor( access = AccessLevel.PROTECTED )
@FieldDefaults( level = AccessLevel.PRIVATE )
public @Getter @Setter class Member {
    @EmbeddedId
    @AttributeOverride( name = "value", column = @Column( name = "memberId" ))
    MemberId id;
    @Embedded
    @AttributeOverride( name = "value", column = @Column( name = "password" ))
    Password pw;
    String name;
    @Embedded
    @AttributeOverride( name = "value", column = @Column( name = "email" ))
    Email email;
    @Embedded
    @AttributeOverride( name = "value", column = @Column( name = "phoneNo" ))
    PhoneNo no;
}
