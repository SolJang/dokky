package com.dokky.shop.api.user.domain.entity;

import com.dokky.shop.api.user.domain.DateOfBirth;
import com.dokky.shop.api.user.domain.Password;
import com.dokky.shop.api.user.domain.UserId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;


@Table(name = "users")
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public @Getter class User {
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
