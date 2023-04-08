package com.dokky.shop.api.user.infra;

import com.dokky.shop.api.user.domain.UserId;
import com.dokky.shop.api.user.domain.entity.Users;
import com.dokky.shop.api.user.domain.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
@Slf4j
public class JpaUserRepository implements UserRepository {
    private final EntityManager entityManager;

    protected JpaUserRepository(EntityManager entityManager) {
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



