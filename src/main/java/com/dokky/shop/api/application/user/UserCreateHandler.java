package com.dokky.shop.api.application.user;

import com.dokky.shop.api.domain.user.Users;
import com.dokky.shop.api.domain.user.entity.UserId;
import com.dokky.shop.api.domain.user.repository.UserRepository;
import com.dokky.shop.api.domain.user.service.CreateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
@RequiredArgsConstructor
public class UserCreateHandler {
    private final UserRepository userRepository;
    private final CreateUserService createUserService;

    @Transactional
    public UserId createUser( CreateUserValidator validator, CreateUserCommand command ) {
        // 필수 값 검증
        List< RuntimeException > errors = validator.validate( command );
        if( !errors.isEmpty() )
            throw errors.get(0);

        Users user = createUserService.createUser( command );

        return userRepository.save( user )
                             .getId();
    }
}
