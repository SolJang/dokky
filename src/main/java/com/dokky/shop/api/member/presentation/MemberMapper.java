package com.dokky.shop.api.member.presentation;

import com.dokky.shop.api.member.application.MemberRegisterCommand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper( componentModel = "spring" )
public interface MemberMapper {
    @Mapping( target = "id.value", source = "memberId" )
    @Mapping( target = "pw.value", source = "password" )
    @Mapping( target = "name", source = "name" )
    @Mapping( target = "email.value", source = "email" )
    @Mapping( target = "no.value", source = "phoneNo" )
    MemberRegisterCommand of( MemberRegisterReq req );
}
