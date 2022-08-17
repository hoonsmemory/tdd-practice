package me.hoon.tdd.practice.assume;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.*;

/**
 * assumeTrue(조건)         : 조건이 맞지 않으면 이하 코드는 실행이 안된다.
 * assumingThat(조건, 테스트) : 조건이 맞을 경우 테스트 코드가 실행된다.
 * @EnabledOnOS, @EnabledOnJre,...   : 조건에 맞을 경우 코드 실행
 * @DisabledOnOS, @DisabledOnJre,... : 조건에 맞을 경우 코드 실행 안함
 */
class AssumeTest {

    @Test
    @DisplayName("Assume 테스트")
    void test() {
        //String test_env = System.getenv("TEST_ENV");
        String test_env = "TEST";
        System.out.println(test_env);

        //assumeTrue("LOCAL".equalsIgnoreCase(test_env));
        System.out.println("에러가 발생하면 이하 코드는 실행이 안된다.");

        assumingThat("LOCAL".equalsIgnoreCase(test_env), ()->{
            System.out.println("에러가 발생하면 실행이 안된다.");
        });

    }

}