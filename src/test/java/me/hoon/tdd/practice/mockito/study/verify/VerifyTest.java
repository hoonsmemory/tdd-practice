package me.hoon.tdd.practice.mockito.study.verify;

import me.hoon.tdd.practice.mockito.domain.Member;
import me.hoon.tdd.practice.mockito.domain.Study;
import me.hoon.tdd.practice.mockito.member.MemberService;
import me.hoon.tdd.practice.mockito.study.StudyRepository;
import me.hoon.tdd.practice.mockito.study.StudyService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Mock 객체가 어떻게 사용이 됐는지 확인할 수 있다.
 *
 * 1. 특정 메소드가 특정 매개변수로 몇번 호출 되었는지(최소 한번은 호출 됐는지, 전혀 호출되지 않았는지)
 * 2. 어떤 순서대로 호출했는지
 * 3. 특정 시간 이내에 호출됐는지
 * 4. 특정 시점 이후에 아무 일도 벌어지지 않았는지
 *
 */
@ExtendWith(MockitoExtension.class)
public class VerifyTest {

    @Mock
    MemberService memberService;

    @Mock
    StudyRepository studyRepository;

    @Test
    @DisplayName("verify 테스트")
    void test() {
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setId(1L);
        member.setName("hoon");
        when(memberService.findById(1L)).thenReturn(Optional.of(member));

        Study study = new Study(10, "테스트 공부");
        when(studyRepository.save(study)).thenReturn(study);

        studyService.createNewStudy(1L, study);
        assertEquals(member, study.getOwner());

        //몇번 호출되었는지 확인
        verify(memberService, times(1)).notify(study);
        verify(memberService, times(1)).notify(member);

        //순서에 맞게 동작했는지 확인
        InOrder inOrder = inOrder(memberService);
        inOrder.verify(memberService).notify(study);
        inOrder.verify(memberService).notify(member);

        //특정 시점 이후에 아무 일도 벌어지지 않았는지 확인
        verifyNoMoreInteractions(memberService);

    }
}
