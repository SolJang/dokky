package com.dokky.shop.api.member.presentation;

import lombok.Getter;

public @Getter class MemberRegisterReq {
    private String memberId;
    private String password;
    private String confirmPassword;
    private String name;
    private String email;
    private String phoneNo;
}
