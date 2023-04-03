package com.dokky.shop.api.users.application;

import com.dokky.shop.api.users.UsersMapper;
import com.dokky.shop.api.users.application.validator.CreateUsersValidator;
import com.dokky.shop.api.users.domain.entity.Users;
import com.dokky.shop.api.users.domain.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

@Slf4j
@Service
public class CreateUsersService {
    private final UsersRepository usersRepository;
    private final CreateUsersValidator createUsersValidator;
    private final UsersMapper mapper;

    public CreateUsersService(UsersRepository usersRepository, CreateUsersValidator createUsersValidator, UsersMapper mapper) {
        this.usersRepository = usersRepository;
        this.createUsersValidator = createUsersValidator;
        this.mapper = mapper;
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
            log.error("userId is already exists > userId : {}", command.id().getValue());
            return;
        }

        // db insert
        usersRepository.save(mapper.commandToUsers(command));
    }
}
