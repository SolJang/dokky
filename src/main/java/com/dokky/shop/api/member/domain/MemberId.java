package com.dokky.shop.api.member.domain;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@FieldDefaults( level = AccessLevel.PRIVATE )
public class MemberId implements Serializable {
    @Column( name = "memberId" )
    String value;
}
