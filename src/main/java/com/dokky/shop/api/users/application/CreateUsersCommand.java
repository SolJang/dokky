package com.dokky.shop.api.users.application;

import com.dokky.shop.api.users.domain.DateOfBirth;
import com.dokky.shop.api.users.domain.Password;
import com.dokky.shop.api.users.domain.UserId;

public record CreateUsersCommand(UserId id,
                                 Password password,
                                 Password confirmPassword,
                                 String name,
                                 DateOfBirth birth,
                                 String sex,
                                 String email,
                                 String mobileNumber
) {
}
