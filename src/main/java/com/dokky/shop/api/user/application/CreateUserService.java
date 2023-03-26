package com.dokky.shop.api.user.application;

import com.dokky.shop.api.user.presentation.dto.CreateUserRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateUserService {
    @Transactional
    public void createUser(CreateUserCommand command) {

        System.out.println(command);


    }


    private void checkPasswordMatch(String password, String confirmPassword) {
        if(!password.equals(confirmPassword)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다");
        }
    }
}
