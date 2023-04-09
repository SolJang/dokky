package com.dokky.shop.api.user.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiException {

    // valid exception
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity handleValidationException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult()
                .getAllErrors()
                .forEach(er -> errors.put(((FieldError)er).getField(), er.getDefaultMessage()));

        return ResponseEntity.badRequest().body(errors);
    }


    // exception
    @ExceptionHandler(Exception.class)
    ResponseEntity handleException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
