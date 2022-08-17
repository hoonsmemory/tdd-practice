package me.hoon.tdd.practice;

import org.junit.jupiter.api.*;

/**
 * 스프링부트 2.2+ 버전부터 JUnit5 의존성이 추가되었다.
 * JUnit은 private 메소드를 테스트 메소드로 사용하지 않는다.
 *
 * @BeforeAll  : 모든 테스트 실행 전 한 번만 실행된다.
 * @AfterAll   : 모든 테스트 실행 후 한 번만 실행된다.
 * 두 메서드를 실행하기 위해서는 static 키워드가 필요하다.
 *
 * @BeforeEach : 각각의 테스트 실행 전 실행된다.
 * @AfterEach  : 각각의 테스트 실행 후 실행된다.
 * @Disabled   : 테스트 하고싶지 않은 메서드에 적용한다.
 *
 */
public class FirstTest {

    @Test
    void create1() {
        System.out.println("create1");
    }

    @Test
    void create2() {
        System.out.println("create2");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach");
    }

}
