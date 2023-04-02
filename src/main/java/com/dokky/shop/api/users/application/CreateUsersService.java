package com.dokky.shop.api.users.application;

import com.dokky.shop.api.users.application.validator.CreateUsersValidator;
import com.dokky.shop.api.users.domain.entity.Users;
import com.dokky.shop.api.users.domain.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

@Service
@Slf4j
public class CreateUsersService {
    private final UsersRepository usersRepository;
    private final CreateUsersValidator createUsersValidator;

    public CreateUsersService(UsersRepository usersRepository, CreateUsersValidator createUsersValidator) {
        this.usersRepository = usersRepository;
        this.createUsersValidator = createUsersValidator;
    }

    @Transactional
    public void createUser(CreateUsersCommand command, BindingResult bindingResult) {
        // 유효성 검사
        createUsersValidator.validate(command, bindingResult);
        if ( bindingResult.hasErrors() ) {
            log.error("user created error > {}", bindingResult.getFieldError().getCode());
            return;
        }

        // 아이디 존재 여부 체크
        if ( usersRepository.findById(command.id()).isPresent() ) {
            log.error("user id is already exists > {}", command.id().getValue());
            return;
        }

        // db insert
        Users users = new Users(command);
        usersRepository.save(users);
    }
}
