package com.dokky.shop.api.member.application;

import com.dokky.shop.api.member.domain.entity.Member;
import com.dokky.shop.api.member.domain.repository.MemberRepository;
import com.dokky.shop.api.member.domain.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberRegisterHandler {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    public Member memberRegister( MemberRegisterCommand command ) {
        System.out.println(" command : " + command );
        Member member = Member.builder()
                .id(command.id())
                .pw(command.pw())
                .name(command.name())
                .email(command.email())
                .no(command.no())
                .build();
        return memberRepository.save(member);

    }

}
