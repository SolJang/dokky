package com.dokky.shop.api.users.domain.repository;

import com.dokky.shop.api.users.domain.UserId;
import com.dokky.shop.api.users.domain.entity.Users;

import java.util.Optional;

public interface UsersRepository {
    void save(Users users);
    Optional<Users> findById(UserId userId);
}
