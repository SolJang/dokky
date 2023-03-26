package com.dokky.shop.api.user.presentation.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Getter @Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateUserRequest {

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
