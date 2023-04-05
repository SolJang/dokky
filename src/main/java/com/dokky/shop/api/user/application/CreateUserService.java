package com.dokky.shop.api.user.application;

import com.dokky.shop.api.user.UserMapper;
import com.dokky.shop.api.user.application.validator.CreateUserValidator;
import com.dokky.shop.api.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

@Slf4j
@RequiredArgsConstructor
@Service
public class CreateUserService {
    private final UserRepository userRepository;
    private final CreateUserValidator createUserValidator;
    private final UserMapper mapper;

    @Transactional
    public void createUser(CreateUserCommand command, BindingResult bindingResult) {
        // 유효성 검사
        createUserValidator.validate(command, bindingResult);
        if ( bindingResult.hasErrors() ) {
            log.error("user created error > {}", bindingResult.getFieldError().getCode());
            return;
        }

        // 아이디 존재 여부 체크
        if ( userRepository.findById(command.id()).isPresent() ) {
            log.error("userId is already exists > userId : {}", command.id().getValue());
            return;
        }

        // db insert
        userRepository.save(mapper.commandToUsers(command));
    }
}
