package me.hoon.tdd.practice.repetition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @RepeatedTest : 반복 횟수와 반복 테스트 이름을 설정할 수 있다.
 * @ParameterizedTest : 테스트에 여러 다른 매개변수를 대입해가며 반복 실행한다.
 */
public class RepetitionTest {

    @DisplayName("반복 테스트")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}" )
    void repeatTest(RepetitionInfo c) {
        System.out.println("test count : " + c.getCurrentRepetition());
    }

    @DisplayName("반복 테스트")
    @ParameterizedTest(name = "{displayName} message[{index}] = {0}")
    @ValueSource(strings = {"여름이", "가고", "가을이", "온다"})
    void parameterizedTest(String message) {
        System.out.println(message);
    }

}
