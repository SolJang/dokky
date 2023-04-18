package com.dokky.shop.api.presentation.user;

import com.dokky.shop.api.application.user.CreateUserCommand;
import com.dokky.shop.api.domain.user.entity.UserId;
import com.dokky.shop.api.domain.user.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "value")
    UserId toUserId(String id);

    @Mapping(source = "id", target = "id.value")
    @Mapping(source = "password", target = "password.value")
    @Mapping(source = "confirmPassword", target = "confirmPassword.value")
    @Mapping(source = "year", target = "birth.year")
    @Mapping(source = "month", target = "birth.month")
    @Mapping(source = "day", target = "birth.day")
    CreateUserCommand of(CreateUserRequest request);

    @Mapping(source = "birth", target = "dateOfBirth")
    Users commandToUsers(CreateUserCommand command);


}
