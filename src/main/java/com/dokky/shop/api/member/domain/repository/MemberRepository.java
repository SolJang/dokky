package com.dokky.shop.api.member.domain.repository;

import com.dokky.shop.api.member.domain.MemberId;
import com.dokky.shop.api.member.domain.entity.Member;

public interface MemberRepository {
    void save( Member member );
    Member findById( MemberId id );
}
