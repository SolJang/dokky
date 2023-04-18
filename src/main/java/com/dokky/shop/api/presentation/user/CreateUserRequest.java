package com.dokky.shop.api.presentation.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Builder
@FieldDefaults( level = AccessLevel.PRIVATE )
public @Getter class CreateUserRequest {
    String id;
    String password;
    String confirmPassword;
    String name;
    String year;
    String month;
    String day;
    String sex;
    String email;
    String mobileNumber;
}
