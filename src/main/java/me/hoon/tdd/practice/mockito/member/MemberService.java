package me.hoon.tdd.practice.mockito.member;

import me.hoon.tdd.practice.mockito.domain.Member;

import java.util.Optional;

public interface MemberService {

    Optional<Member> findById(Long memberId) throws MemberNotFoundException;
}
