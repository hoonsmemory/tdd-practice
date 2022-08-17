package me.hoon.tdd.practice.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * assertEqulas(expected, actual)         : 실제 값이 기대한 값과 같은지 확인
 * assertNotNull(actual)                  : 값이 null이 아닌지 확인
 * assertTrue(boolean)                    : 다음 조건이 참(true)인지 확인
 * assertAll(executables...)              : 모든 확인 구문 확인
 * assertThrows(expectedType, executable) : 예외 발생 확인
 * assertTimeout(duration, executable)    : 특정 시간 안에 실행이 완료되는지 확인
 */
class StudyTest {

    @Test
    @DisplayName("스터디 만들기")
    void createNewStudy() {
        Study study = new Study(1);

        assertAll(
                ()-> assertNotNull(study),
                ()-> assertEquals(StudyStatus.DRAFT, study.getStatus(), "테스트가 실패했을 때만 메세지를 볼 수 있다."),
                ()-> assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0명 이상이어야 합니다.")
        );

        assertNotNull(study);
        assertEquals(StudyStatus.DRAFT, study.getStatus(), "테스트가 실패했을 때만 메세지를 볼 수 있다.");
        assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0명 이상이어야 합니다.");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        System.out.println(exception.getMessage());


    }
}