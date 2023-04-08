package com.dokky.shop.api.user.infra;

import com.dokky.shop.api.user.domain.UserId;
import com.dokky.shop.api.user.domain.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<Users, UserId> {

}



