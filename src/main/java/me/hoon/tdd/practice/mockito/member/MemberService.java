package me.hoon.tdd.practice.mockito.member;

import me.hoon.tdd.practice.mockito.domain.Member;
import me.hoon.tdd.practice.mockito.domain.Study;

import java.util.Optional;

public interface MemberService {

    Optional<Member> findById(Long memberId) throws MemberNotFoundException;

    void notify(Study study);

    void notify(Member member);
}
