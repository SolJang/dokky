package com.dokky.shop.api.domain.user.repository;

import com.dokky.shop.api.domain.user.entity.UserId;
import com.dokky.shop.api.domain.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, UserId> {

}



