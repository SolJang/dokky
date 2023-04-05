package com.dokky.shop.api.user.domain.repository;

import com.dokky.shop.api.user.domain.UserId;
import com.dokky.shop.api.user.domain.entity.Users;

import java.util.Optional;

public interface UserRepository {
    void save(Users users);
    Optional<Users> findById(UserId userId);
}
