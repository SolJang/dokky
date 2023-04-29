package com.dokky.shop.api.member.presentation;

import com.dokky.shop.api.member.application.MemberRegisterHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping( MemberController.PREFIX )
public class MemberController {
    static final String PREFIX = "/member";
    static final String URI_MEMBER_CREATE = "/register";

    private final MemberRegisterHandler handler;
    private final MemberMapper mapper;

    /**
     * 멤버 회원가입
     * @param memberRegisterReq
     */
    @PostMapping( value = URI_MEMBER_CREATE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public void memberRegister( MemberRegisterReq memberRegisterReq ) {

        handler.memberRegister( mapper.of( memberRegisterReq ) );

    }

}
