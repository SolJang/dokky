package com.dokky.shop.api.user.presentation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UserController.PREFIX)
public class UserController {
    public static final String PREFIX = "/user";
}
