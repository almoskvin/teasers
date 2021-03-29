package com.github.almoskvin.teasers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionDifferByOneTest {

    SolutionDifferByOne solution = new SolutionDifferByOne();

    @ParameterizedTest
    @MethodSource("testSourcesProvider")
    void solution(boolean expected, int[] input) {
        assertEquals(expected, solution.solution(input));
    }

    private static Stream<Arguments> testSourcesProvider() {
        return Stream.of(
                Arguments.of(false, new int[]{7}),
                Arguments.of(true, new int[]{4, 3}),
                Arguments.of(true, new int[]{11, 1, 8, 12, 14}),
                Arguments.of(true, new int[]{4, 10, 8, 5, 9}),
                Arguments.of(false, new int[]{5, 5, 5, 5, 5})
        );
    }
}