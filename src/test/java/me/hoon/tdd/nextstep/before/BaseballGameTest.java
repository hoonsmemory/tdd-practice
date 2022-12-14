package me.hoon.tdd.nextstep.before;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Scanner;
import me.hoon.tdd.nextstep.before.baseball.BaseballGame;
import me.hoon.tdd.nextstep.before.baseball.InputView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGameTest {

    static BaseballGame baseball = null;
    static InputView inputView = null;

    @BeforeAll
    static void init() {
        baseball = new BaseballGame();
        inputView = new InputView();
    }


    @DisplayName("랜덤 숫자 테스트")
    @Test
    void drawTest() {
        for(int i = 0; i < 1000; i++) {
            int[] numbers = baseball.draw3Numbers();
            assertThat(numbers.length).isEqualTo(3);

            for (int number : numbers) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    @DisplayName("")
    @Test
    void playTest() {

    }

}