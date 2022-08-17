package me.hoon.tdd.practice.repetition.detail;

import me.hoon.tdd.practice.assertion.Study;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RepetitionTest {

    @DisplayName("@ValueSource를 사용, 파라미터가 한개일 경우")
    @ParameterizedTest(name = "{displayName} message[{index}] = {0}")
    //@ValueSource(strings = {"여름이", "가고", "가을이", "온다"})
    //@NullAndEmptySource // null과 공백이 들어간다.
    @ValueSource(ints = {10, 20, 30})
    void parameterizedTest1(@ConvertWith(StudyConverter.class) Study study) {
        System.out.println(study.getLimit());
    }

    @DisplayName("@CsvSource 사용. 파라미터가 여러개 일 경우")
    @ParameterizedTest()
    @CsvSource({"10, '자바 스터디'", "20, 스프링"})
    void parameterizedTest2(Integer limit, String name) {
        System.out.println(new Study(limit, name));
    }

    @DisplayName("@CsvSource, ArgumentsAccessor 사용")
    @ParameterizedTest()
    @CsvSource({"10, '자바 스터디'", "20, 스프링"})
    void parameterizedTest3(ArgumentsAccessor argumentsAccessor) {
        System.out.println(new Study(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1)));
    }

    @DisplayName("@CsvSource, ArgumentsAccessor 사용")
    @ParameterizedTest()
    @CsvSource({"10, '자바 스터디'", "20, 스프링"})
    void parameterizedTest4(@AggregateWith(StudyAggregator.class) Study study) {
        System.out.println(study.toString());
    }

    static class StudyAggregator implements ArgumentsAggregator {

        @Override
        public Object aggregateArguments(ArgumentsAccessor argumentsAccessor, ParameterContext parameterContext) throws ArgumentsAggregationException {
            return new Study(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));
        }
    }

    static class StudyConverter extends SimpleArgumentConverter {
        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            Assertions.assertEquals(Study.class, targetType, "Can only convert to Study");
            return new Study(Integer.parseInt(source.toString()));
        }
    }



}
