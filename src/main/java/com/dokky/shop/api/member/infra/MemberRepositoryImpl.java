package com.dokky.shop.api.member.infra;

import com.dokky.shop.api.common.MemberId;
import com.dokky.shop.api.member.domain.entity.Member;
import com.dokky.shop.api.member.domain.repository.MemberRepository;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositoryImpl extends QuerydslRepositorySupport implements MemberRepository {

    MemberRepositoryImpl() {
        super(Member.class);
    }
    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public Member findById(MemberId id) {
        return null;
    }
}
