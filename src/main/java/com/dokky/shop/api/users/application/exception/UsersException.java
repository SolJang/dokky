package com.dokky.shop.api.users.application.exception;

public class UsersException extends Exception {

    UsersException(){};

    public UsersException(String msg) {
        super(msg);
    }
}
