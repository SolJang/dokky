package com.dokky.shop.api.presentation.user;

import com.dokky.shop.api.application.user.*;
import com.dokky.shop.api.domain.user.entity.UserId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(UserController.PREFIX)
@RequiredArgsConstructor
public class UserController {
    public static final String PREFIX = "/api/users";
    private final UserCreateHandler userCreateHandler;
    private final CreateUserValidator createUserValidator;
    private final ReadUserService readService;
    private final UpdateUserService updateService;
    private final DeleteUserService deleteService;
    private final UserMapper mapper;

    @PostMapping
    public ResponseEntity< ? > signUp(@RequestBody CreateUserRequest request) {
        UserId userId = userCreateHandler.createUser( createUserValidator, mapper.of(request) );
        log.info("userID : {}", userId);
        return ResponseEntity.status(HttpStatus.OK).build();

//        return ResponseHandler.of( () -> {
//            userCreateHandler.createUser( createUserValidator, mapper.of(request) );
//            return null;
//        }).onError( ex -> {
//            return errorMapper.map( ex );
//        })

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
