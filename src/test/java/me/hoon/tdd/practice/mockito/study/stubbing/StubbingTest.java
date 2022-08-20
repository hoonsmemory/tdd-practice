package me.hoon.tdd.practice.mockito.study.stubbing;

import me.hoon.tdd.practice.mockito.domain.Member;
import me.hoon.tdd.practice.mockito.domain.Study;
import me.hoon.tdd.practice.mockito.member.MemberService;
import me.hoon.tdd.practice.mockito.study.StudyRepository;
import me.hoon.tdd.practice.mockito.study.StudyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StubbingTest {

    @Mock MemberService memberService;

    @Mock
    StudyRepository studyRepository;

    @Test
    @DisplayName("Mock 객체 Stubbing 테스트")
    void test() {
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        // memberService 객체에 findById 메소드를 1L 값으로 호출하면 Optional.of(member) 객체를 리턴하도록 Stubbing
        Member member = new Member();
        member.setId(1L);
        member.setName("hoon");

        when(memberService.findById(1L)).thenReturn(Optional.of(member));

        // studyRepository 객체에 save 메소드를 study 객체로 호출하면 study 객체 그대로 리턴하도록 Stubbing
        Study study = new Study(10, "테스트 공부");
        when(studyRepository.save(study)).thenReturn(study);

        studyService.createNewStudy(1L, study);
        assertEquals(member, study.getOwner());
    }

}
