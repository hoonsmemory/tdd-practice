package me.hoon.tdd.practice.methodorder;

import org.junit.jupiter.api.*;

/**
 * @TestMethodOrder
 * 테스트 메소드를 원하는 순서에 따라 실행하도록 할 수 있다.
 *
 * @TestInstance(TestInstance.Lifecycle.PER_CLASS) 와도 함께 사용할 수 있다.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderTest {

    @Order(1)
    @Test
    void lastMethod() {
        System.out.println("lastMethod");
    }

    @Order(2)
    @Test
    void firstMethod() {
        System.out.println("firstMethod");
    }

    @Order(3)
    @Test
    void middleMethod() {
        System.out.println("middleMethod");
    }

}
