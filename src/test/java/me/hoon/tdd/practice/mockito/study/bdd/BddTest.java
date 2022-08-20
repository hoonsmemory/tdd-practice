package me.hoon.tdd.practice.mockito.study.bdd;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class BddTest {

    @Mock
    MemberService memberService;

    @Mock
    StudyRepository studyRepository;

    @Test
    @DisplayName("BDD 스타일 test")
    void test() {
        //Given - 주어진 상황
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setId(1L);
        member.setName("hoon");

        Study study = new Study(10, "테스트 공부");

        //when(memberService.findById(1L)).thenReturn(Optional.of(member));
        //when(studyRepository.save(study)).thenReturn(study);
        given(memberService.findById(1L)).willReturn(Optional.of(member));
        given(studyRepository.save(study)).willReturn(study);

        //When - 주어진 상황에서 어떠한 행동을 했을 때
        studyService.createNewStudy(1L, study);

        //Then - 이러한 결과가 나올 것이다.
        assertEquals(member, study.getOwner());
        //verify(memberService, times(1)).notify(study);
        //verify(memberService, times(1)).notify(member);
        //verifyNoMoreInteractions(memberService);
        then(memberService).should(times(1)).notify(study);
        then(memberService).should(times(1)).notify(member);
        then(memberService).shouldHaveNoMoreInteractions();
    }
}
