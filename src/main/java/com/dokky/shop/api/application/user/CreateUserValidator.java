package com.dokky.shop.api.application.user;

import java.util.ArrayList;
import java.util.List;

public interface CreateUserValidator {

    default List<RuntimeException> validate(CreateUserCommand command) {
        List<RuntimeException> errors = new ArrayList<>();

        if ( command.id().getValue() == null )
            errors.add( new IllegalArgumentException("아이디를 입력해주세요.") );

        if ( command.password().getValue() == null || command.confirmPassword().getValue() == null )
            errors.add( new IllegalArgumentException("비밀번호를 입력해주세요.") );

        if ( command.name() == null )
            errors.add( new IllegalArgumentException("이름을 입력해주세요.") );

        return errors;
    }
}
