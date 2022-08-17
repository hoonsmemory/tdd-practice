package me.hoon.tdd.practice.testInstance;

import org.junit.jupiter.api.*;

/**
 * @TestInstance
 * 테스트 클래스당 인스턴스를 하나만 만들어 사용한다.
 * 경우에 따라, 테스트 간에 공유하는 모든 상태를 @BeforeEach 또는 @AfterEach에서 초기화 할 필요가 있다.
 * @BeforeAll과 @AfterAll을 인스턴스 메소드 또는 인터페이스에 정의한 default 메소드로 정의할 수도 있다.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestInstanceTest {

    int value = 0;

    @BeforeAll
    void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterAll
    void afterAll() {
        System.out.println("afterAll");
    }

    @Test
    void test1() {
        System.out.print(++value);
        System.out.println(" : " + this);
    }

    @Test
    void test2() {
        System.out.print(++value);
        System.out.println(" : " + this);
    }
}
