package com.dokky.shop.api.user.application;

import com.dokky.shop.api.user.domain.DateOfBirth;
import com.dokky.shop.api.user.domain.Password;
import com.dokky.shop.api.user.domain.UserId;

import java.sql.Date;

public record CreateUserCommand(UserId id,
                                Password password,
                                Password confirmPassword,
                                String name,
                                DateOfBirth birth,
                                String sex,
                                String email,
                                String mobileNumber
) {
}
