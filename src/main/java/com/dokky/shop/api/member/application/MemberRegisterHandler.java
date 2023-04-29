package com.dokky.shop.api.member.application;

import com.dokky.shop.api.member.domain.repository.MemberRepository;
import com.dokky.shop.api.member.domain.service.MemberService;
import com.dokky.shop.api.member.presentation.MemberRegisterReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberRegisterHandler {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    public void memberRegister( MemberRegisterReq memberRegisterReq ) {
        // valid check
        // repository save
    }

}
