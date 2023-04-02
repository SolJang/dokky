package com.dokky.shop.api.users.infra;

import com.dokky.shop.api.users.domain.UserId;
import com.dokky.shop.api.users.domain.entity.Users;
import com.dokky.shop.api.users.domain.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
@Slf4j
public class JpaUsersRepository implements UsersRepository {

    private final EntityManager entityManager;

    public JpaUsersRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Users users) {
        entityManager.persist(users);
    }

    @Override
    public Optional<Users> findById(UserId userId) {
        return Optional.ofNullable(entityManager.find(Users.class, userId));
    }
}



