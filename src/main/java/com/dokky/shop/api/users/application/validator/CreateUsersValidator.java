package com.dokky.shop.api.users.application.validator;

import com.dokky.shop.api.users.application.CreateUsersCommand;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
@Slf4j
public class CreateUsersValidator implements Validator {

    // 검증하려는 클래스 체크
    @Override
    public boolean supports(Class<?> clazz) {
        return CreateUsersCommand.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CreateUsersCommand command = (CreateUsersCommand) target;

        if ( StringUtils.isEmpty(command.id().getValue()) )
            errors.rejectValue("id", "아이디를 입력해주세요.");

        if ( StringUtils.isEmpty(command.password().getValue())
                || StringUtils.isEmpty(command.confirmPassword().getValue()) )
            errors.rejectValue("password", "비밀번호를 입력해주세요.");

        if ( !command.password().getValue().equals(command.confirmPassword().getValue()) )
            errors.rejectValue("password", "비밀번호가 일치하지 않습니다.");

        if ( StringUtils.isEmpty(command.name()) )
            errors.rejectValue("name", "이름을 입력해주세요.");

        if ( StringUtils.isEmpty(command.email()) )
            errors.rejectValue("email", "이메일을 입력해주세요.");

        // email regex
        String emailRegex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
        Pattern pattern = Pattern.compile(emailRegex);
        if ( !pattern.matcher(command.email()).matches() )
            errors.rejectValue("email", "이메일 형식을 확인해주세요.");

        if ( StringUtils.isEmpty(command.mobileNumber()) )
            errors.rejectValue("mobileNumber", "전화번호를 입력해주세요.");

        if ( command.mobileNumber().length() != 11 )
            errors.rejectValue("mobileNumber", "전화번호를 확인해주세요.");

        if ( StringUtils.isEmpty(command.sex()) )
            errors.rejectValue("sex", "성별을 입력해주세요.");

        if ( ObjectUtils.isEmpty(command.birth().toLocalDate()) )
            errors.rejectValue("birth", "생년월일을 확인해주세요.");
    }
}
