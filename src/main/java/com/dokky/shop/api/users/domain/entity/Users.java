package com.dokky.shop.api.users.domain.entity;

import com.dokky.shop.api.users.domain.DateOfBirth;
import com.dokky.shop.api.users.domain.Password;
import com.dokky.shop.api.users.domain.UserId;
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
