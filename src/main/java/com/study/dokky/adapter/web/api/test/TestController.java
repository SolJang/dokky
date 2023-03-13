package com.study.dokky.adapter.web.api.test;

import com.study.dokky.adapter.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("TestController")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private static final String URI_PREFIX = "/api";
    private static final String URI_MEMBER_INFO = URI_PREFIX + "/member/info";


    @GetMapping("/")
    public String welcome(String msg){
        log.info("===================START");

        return "welcome dokky study ^____________^";
    }

    @GetMapping(value = URI_MEMBER_INFO, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse getSample (MemberRequest memberRequest){
        String result = "";

        log.info("GET memberRequest: {}", memberRequest.toString());
        return new ApiResponse.Builder()
                .result(result)
                .build();
    }

    @PostMapping(value = URI_MEMBER_INFO, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ApiResponse postSample (MemberRequest memberRequest){
        log.info("POST memberRequest: {}", memberRequest.toString());
        String result = "";
        return new ApiResponse.Builder()
                .result(result)
                .build();
    }
}
