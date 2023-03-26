package com.dokky.shop.api.user.presentation;

import com.dokky.shop.api.user.UserMapper;
import com.dokky.shop.api.user.application.*;
import com.dokky.shop.api.user.domain.entity.User;
import com.dokky.shop.api.user.presentation.dto.CreateUserRequest;
import com.dokky.shop.api.user.presentation.dto.UpdateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UserController.PREFIX)
@RequiredArgsConstructor
public class UserController {
    public static final String PREFIX = "/api/user";

    private final CreateUserService createService;
    private final ReadUserService readService;
    private final UpdateUserService updateService;
    private final DeleteUserService deleteService;

    private final UserMapper mapper;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String signUp(@RequestBody CreateUserRequest request) {
        createService.createUser(mapper.of(request));
        return "사용자 생성 완료";
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String readUser(@PathVariable String id) {
        System.out.println(id);
        return "사용자 조회";
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@RequestBody UpdateUserRequest request, @PathVariable String id) {
        System.out.println(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void withdrawUser(@PathVariable String id) {

    }
}
