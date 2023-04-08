package com.dokky.shop.api.user.application;

import com.dokky.shop.api.user.UserMapper;
import com.dokky.shop.api.user.infra.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class CreateUserService {
    private final JpaUserRepository jpsUserRepository;
    private final UserMapper mapper;

    @Transactional
    public void createUser(CreateUserCommand command) {
        // 비밀번호 체크
        if ( !checkPasswordAndPasswordConfirm(command) ) {
            log.error("password confirm comparison is fail");
            return;
        }
        // 아이디 존재 여부 체크
        if ( jpsUserRepository.findById(command.id()).isPresent() ) {
            log.error("userId is already exists > userId : {}", command.id().getValue());
            return;
        }

        // db insert
        jpsUserRepository.save(mapper.commandToUsers(command));
    }

    private boolean checkPasswordAndPasswordConfirm(CreateUserCommand command) {
        return command.password().getValue().equals(command.confirmPassword().getValue());
    }
}
