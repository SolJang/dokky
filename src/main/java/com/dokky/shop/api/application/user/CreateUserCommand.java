package com.dokky.shop.api.application.user;

import com.dokky.shop.api.domain.user.entity.DateOfBirth;
import com.dokky.shop.api.domain.user.entity.Password;
import com.dokky.shop.api.domain.user.entity.UserId;

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
