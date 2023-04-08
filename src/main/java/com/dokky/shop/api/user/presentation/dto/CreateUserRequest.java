package com.dokky.shop.api.user.presentation.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.*;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateUserRequest {
    @NotBlank(message = "아이디를 입력해주세요.")
    String id;
    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Min(value = 8, message = "비밀번호는 8자리 이상 입력해주세요.")
    String password;
    @NotBlank(message = "비밀번호 확인을 입력해주세요.")
    @Min(value = 8, message = "비밀번호는 8자리 이상 입력해주세요.")
    String confirmPassword;
    @NotBlank(message = "이름을 입력해주세요.")
    String name;
    String year;
    String month;
    String day;
    String sex;
    @Email(message = "이메일 형식을 확인해주세요.")
    String email;
    @NotBlank(message = "휴대폰번호를 입력해주세요.")
    @Pattern(regexp = "^[0-9]+$", message = "휴대폰번호는 숫자만 입력해주세요.")
    String mobileNumber;
}
