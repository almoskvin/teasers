package com.github.almoskvin.teasers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTheBiggestWithFiveTest {

    SolutionTheBiggestWithFive solution = new SolutionTheBiggestWithFive();

    @ParameterizedTest
    @MethodSource("testSourcesProvider")
    void solution(int expected, int input) {
        assertEquals(expected, solution.solution(input));
    }

    private static Stream<Arguments> testSourcesProvider() {
        return Stream.of(
                Arguments.of(5268, 268),
                Arguments.of(6750, 670),
                Arguments.of(50, 0),
                Arguments.of(-5999, -999)
        );
    }

}