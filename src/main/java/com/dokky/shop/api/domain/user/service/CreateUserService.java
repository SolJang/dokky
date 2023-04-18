package com.dokky.shop.api.domain.user.service;

import com.dokky.shop.api.application.user.CreateUserCommand;
import com.dokky.shop.api.domain.user.Users;
import com.dokky.shop.api.domain.user.entity.UserId;
import com.dokky.shop.api.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CreateUserService {

    private final UserRepository userRepository;

    @Transactional
    public Users createUser( CreateUserCommand command ) {

        // 비밀번호 체크
        if ( !checkPasswordAndPasswordConfirm( command ) ) {
            log.error("password confirm comparison is fail");
            throw new IllegalArgumentException("not match password");
        }

        // 이미 등록된 아이디있는지 체크
        if ( checkUserIdAlreadyExists( command.id() )) {
            log.error("userId is already exists > userId : {}", command.id().getValue());
            throw new IllegalArgumentException("userId is already exists > userId : " + command.id().getValue());
        }

        return Users.builder()
                .id(command.id())
                .password(command.password())
                .email(command.email())
                .name(command.name())
                .mobileNumber(command.mobileNumber())
                .sex(command.sex())
                .dateOfBirth(command.birth())
                .build();
    }

    private boolean checkPasswordAndPasswordConfirm( CreateUserCommand command ) {
        return command.password().getValue().equals( command.confirmPassword().getValue() );
    }

    private boolean checkUserIdAlreadyExists( UserId userId ) {
        return userRepository.findById( userId ).isPresent();
    }
}
