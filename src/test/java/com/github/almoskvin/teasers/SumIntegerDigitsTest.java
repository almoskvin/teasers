package com.github.almoskvin.teasers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SumIntegerDigitsTest {

    private static Stream<Arguments> sourceProvider() {
        SumIntegerDigits.Tree<Integer> thirdLeft = new SumIntegerDigits.Tree<>(10);
        SumIntegerDigits.Tree<Integer> thirdRight = new SumIntegerDigits.Tree<>(4);
        SumIntegerDigits.Tree<Integer> secondLeft = new SumIntegerDigits.Tree<>(2, thirdLeft, thirdRight);
        SumIntegerDigits.Tree<Integer> secondRight = new SumIntegerDigits.Tree<>(-3);
        SumIntegerDigits.Tree<Integer> first = new SumIntegerDigits.Tree<>(5, secondLeft, secondRight);
        return Stream.of(
                Arguments.of(
                        first,
                        new String[]{"5->2->10", "5->2->4", "5->-3"})
        );
    }

    @ParameterizedTest
    @MethodSource("sourceProvider")
    void solution(SumIntegerDigits.Tree<Integer> t, String[] expected) {
        String[] result = SumIntegerDigits.solution(t);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertEquals(expected[i], result[i]);
        }
    }
}