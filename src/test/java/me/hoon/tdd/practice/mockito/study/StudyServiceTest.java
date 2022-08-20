package me.hoon.tdd.practice.mockito.study;

import me.hoon.tdd.practice.mockito.domain.Member;
import me.hoon.tdd.practice.mockito.domain.Study;
import me.hoon.tdd.practice.mockito.member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * 1. Mockito.mock() 메서드로 만드는 방법
 * MemberService memberService = mock(MemberService.class);
 * StudyRepository studyRepository = mock(StudyRepository.class);
 *
 * 2. @Mock 애노테이션으로 만드는 방법
 * @ExtendWith(MockitoExtension.class)
 * class ...Test
 *
 * @Mock MemberService memberService;
 * @Mock StudyRepository studyRepository;
 *
 * 모든 Mock 객체의 행동
 * 1. Null을 리턴한다. (Optional 타입은 Optional.empty 리턴)
 * 2. Primitive 타입은 기본 Primitive 값. (int = 0, String = null ..)
 * 3. 컬렉션은 비어있는 콜렉션.
 * 4. Void 메소드는 예외를 던지지 않고 아무런 일도 발생하지 않는다.
 */
@ExtendWith(MockitoExtension.class)
class StudyServiceTest {

    @Mock
    MemberService memberService;

    @Mock
    StudyRepository studyRepository;

    @Test
    void createStudyService() {
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        /**
         * Stubbing
         * 1. 특정한 매개변수를 받은 경우 특정한 값을 리턴하거나 예외를 던지도록 만들 수 있다.
         * 2. Void 메소드 특정 매개변수를 받거나 호출된 경우 예외를 발생 시킬 수 있다.
         * 3. 메소드가 동일한 매개변수로 여러번 호출될 때 각기 다르게 행동호도록 조작할 수도 있다.
         */
        Member member = new Member();
        member.setId(1L);
        member.setName("hoon");

        //명시적으로 값을 넣어주거나 any()를 사용해서 간접적으로 값을 넣어줄 수 있다.
        when(memberService.findById(anyLong())).thenReturn(Optional.of(member));
        //when(memberService.findById(2L)).thenThrow(new IllegalArgumentException());
        //doThrow(new IllegalArgumentException()).when(memberService).findById(1L);

        Optional<Member> foundMember = memberService.findById(1L);
        assertEquals("hoon", foundMember.get().getName());

        Study study = new Study(10, "Java");
        studyService.createNewStudy(1L, study);
    }
}