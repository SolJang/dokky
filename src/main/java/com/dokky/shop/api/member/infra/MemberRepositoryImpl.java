package com.dokky.shop.api.member.infra;

import com.dokky.shop.api.member.domain.MemberId;
import com.dokky.shop.api.member.domain.entity.Member;
import com.dokky.shop.api.member.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {
    private final EntityManager entityManager;

    @Override
    public void save(Member member) {
        entityManager.persist( member );
    }

    @Override
    public Member findById(MemberId id) {
        return entityManager.find( Member.class, id );
    }
}
