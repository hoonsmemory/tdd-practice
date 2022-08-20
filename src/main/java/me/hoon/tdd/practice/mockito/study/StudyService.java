package me.hoon.tdd.practice.mockito.study;

import me.hoon.tdd.practice.mockito.domain.Member;
import me.hoon.tdd.practice.mockito.domain.Study;
import me.hoon.tdd.practice.mockito.member.MemberService;

import java.util.Optional;

public class StudyService {

    private final MemberService memberService;

    private final StudyRepository studyRepository;

    public StudyService(MemberService memberService, StudyRepository studyRepository) {
        assert memberService != null;
        assert studyRepository != null;

        this.memberService = memberService;
        this.studyRepository = studyRepository;
    }

    public Study createNewStudy(Long memberId, Study study) {
        Optional<Member> member = memberService.findById(memberId);
        study.setOwner(member.orElseThrow(()-> new IllegalArgumentException("member doesn't exist for id : " + memberId)));

        Study newStudy = studyRepository.save(study);
        memberService.notify(newStudy);
        memberService.notify(member.get());

        return newStudy;
    }
}
