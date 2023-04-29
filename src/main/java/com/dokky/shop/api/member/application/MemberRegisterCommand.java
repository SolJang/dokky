package com.dokky.shop.api.member.application;

import com.dokky.shop.api.common.Email;
import com.dokky.shop.api.common.MemberId;
import com.dokky.shop.api.common.Password;
import com.dokky.shop.api.common.PhoneNo;

public record MemberRegisterCommand(MemberId id,
                                    Password pw,
                                    String name,
                                    Email email,
                                    PhoneNo no ) {
}
