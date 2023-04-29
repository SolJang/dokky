package com.dokky.shop.api.member.domain.repository;

import com.dokky.shop.api.common.MemberId;
import com.dokky.shop.api.member.domain.entity.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository {
    Member save( Member member );
    Member findById( MemberId id );
}
