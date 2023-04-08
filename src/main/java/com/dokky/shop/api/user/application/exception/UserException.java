package com.dokky.shop.api.user.application.exception;

public class UserException extends Exception {

    UserException(){};

    protected UserException(String msg) {
        super(msg);
    }
}
