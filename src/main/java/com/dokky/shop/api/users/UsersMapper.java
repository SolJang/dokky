package com.dokky.shop.api.users;

import com.dokky.shop.api.users.application.CreateUsersCommand;
import com.dokky.shop.api.users.domain.UserId;
import com.dokky.shop.api.users.domain.entity.Users;
import com.dokky.shop.api.users.presentation.dto.CreateUsersRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    @Mapping(source = "id", target = "value")
    UserId toUserId(String id);

    @Mapping(source = "id", target = "id.value")
    @Mapping(source = "password", target = "password.value")
    @Mapping(source = "confirmPassword", target = "confirmPassword.value")
    @Mapping(source = "year", target = "birth.year")
    @Mapping(source = "month", target = "birth.month")
    @Mapping(source = "day", target = "birth.day")
    CreateUsersCommand of(CreateUsersRequest request);

    @Mapping(source = "birth", target = "dateOfBirth")
    Users commandToUsers(CreateUsersCommand command);


}
