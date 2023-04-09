package com.dokky.shop.api.user.presentation;

import com.dokky.shop.api.user.UserMapper;
import com.dokky.shop.api.user.application.CreateUserService;
import com.dokky.shop.api.user.application.DeleteUserService;
import com.dokky.shop.api.user.application.ReadUserService;
import com.dokky.shop.api.user.application.UpdateUserService;
import com.dokky.shop.api.user.presentation.dto.CreateUserRequest;
import com.dokky.shop.api.user.presentation.dto.UpdateUserRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping(UserController.PREFIX)
@RequiredArgsConstructor
public class UserController {
    public static final String PREFIX = "/api/users";
    private final CreateUserService createService;
    private final ReadUserService readService;
    private final UpdateUserService updateService;
    private final DeleteUserService deleteService;
    private final UserMapper mapper;

    @PostMapping
    public ResponseEntity signUp(@RequestBody @Valid CreateUserRequest request) {
        createService.createUser(mapper.of(request));
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();

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
