package com.dokky.shop.api.users.presentation;

import com.dokky.shop.api.users.UsersMapper;
import com.dokky.shop.api.users.application.CreateUsersService;
import com.dokky.shop.api.users.application.DeleteUsersService;
import com.dokky.shop.api.users.application.ReadUsersService;
import com.dokky.shop.api.users.application.UpdateUsersService;
import com.dokky.shop.api.users.application.validator.CreateUsersValidator;
import com.dokky.shop.api.users.presentation.dto.CreateUsersRequest;
import com.dokky.shop.api.users.presentation.dto.UpdateUsersRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(UsersController.PREFIX)
@RequiredArgsConstructor
public class UsersController {
    public static final String PREFIX = "/api/users";
    private final CreateUsersService createService;
    private final ReadUsersService readService;
    private final UpdateUsersService updateService;
    private final DeleteUsersService deleteService;
    private final UsersMapper mapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String signUp(@RequestBody CreateUsersRequest request, BindingResult bindingResult) {
        createService.createUser(mapper.of(request), bindingResult);
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
    public void updateUser(@RequestBody UpdateUsersRequest request, @PathVariable String id) {
        System.out.println(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void withdrawUser(@PathVariable String id) {

    }
}
