package me.hoon.tdd.nextstep.before;

import java.io.ByteArrayInputStream;
import me.hoon.tdd.nextstep.before.baseball.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {


    //https://stackoverflow.com/questions/16066671/how-can-i-unit-test-user-input-in-java
    @DisplayName("숫자 입력 테스트")
    @Test
    void test1() {

        String data = "123";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        InputView inputView = new InputView();
        int[] input = inputView.input();

        Assertions.assertThat(input).contains(1, 2, 3);
    }

}