package com.dokky.shop.api.user.presentation;

import com.dokky.shop.api.presentation.user.CreateUserRequest;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private final String url = "/api/users";

    @Test
    @DisplayName("사용자 회원가입 유효성 검사 실패_userId")
    void signUp_fail_userId() throws Exception {
        // given
        CreateUserRequest request = makeUserRequest("", "12341234", "12341234", "장솔", "1996", "01", "01", "F", "thf147@naver.com", "01062487523");
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(request)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("사용자 회원가입 유효성 검사 실패_password")
    void signUp_fail_password() throws Exception {
        // given
        CreateUserRequest request = makeUserRequest("ddol", "", "12341234", "장솔", "1996", "01", "01", "F", "thf147@naver.com", "01062487523");
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(request)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("사용자 회원가입 유효성 검사 실패_not match password")
    void signUp_fail_notMatchPassword() throws Exception{
        // given
        CreateUserRequest request = makeUserRequest("ddol", "12341234", "123412345", "장솔", "1996", "01", "01", "F", "thf147@naver.com", "01062487523");
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(request)))
                .andExpect(status().isOk())
                .andDo(print());
    }


    @Test
    @DisplayName("사용자 회원가입 유효성 검사_userName")
    void signUp_fail_userName() throws Exception{
        // given
        CreateUserRequest request = makeUserRequest("", "12341234", "12341234", "", "1996", "01", "01", "F", "thf147@naver.com", "01062487523");
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(request)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("사용자 회원가입 성공")
    void signUp_success() throws Exception{
        // given
        CreateUserRequest request = makeUserRequest("ddol", "12341234", "12341234", "장솔", "1996", "01", "01", "F", "thf147@naver.com", "01062487523");
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(request)))
                .andExpect(status().isOk())
                .andDo(print());
    }

    private CreateUserRequest makeUserRequest(String id,
                                              String password,
                                              String confirmPassword,
                                              String name,
                                              String year,
                                              String month,
                                              String day,
                                              String sex,
                                              String email,
                                              String mobileNumber) {
        return CreateUserRequest
                .builder()
                .id(id)
                .password(password)
                .confirmPassword(confirmPassword)
                .name(name)
                .year(year)
                .month(month)
                .day(day)
                .sex(sex)
                .email(email)
                .mobileNumber(mobileNumber)
                .build();
    }

}