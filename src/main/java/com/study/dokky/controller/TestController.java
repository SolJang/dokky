package com.study.dokky.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @GetMapping("/")
    public String welcome(String msg){
        log.info("===================START");

        return "welcome dokky study ^____________^";
    }
}
