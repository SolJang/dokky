package com.dokky.shop.api.user.application.exception;

public class UserException extends Exception {

    UserException(){};

    public UserException(String msg) {
        super(msg);
    }
}
