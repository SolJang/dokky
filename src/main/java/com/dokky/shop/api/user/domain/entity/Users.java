package com.dokky.shop.api.user.domain.entity;

import com.dokky.shop.api.user.domain.DateOfBirth;
import com.dokky.shop.api.user.domain.Password;
import com.dokky.shop.api.user.domain.UserId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public @Getter @Setter class Users {
    @EmbeddedId
    UserId id;
    @Embedded
    Password password;
    String email;
    String name;
    String mobileNumber;
    String sex;
    @Embedded
    DateOfBirth dateOfBirth;
}
