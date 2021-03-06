package com.github.almoskvin.teasers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionFirstPositiveTest {

    SolutionFirstPositive solutionFirstPositive = new SolutionFirstPositive();

    @ParameterizedTest
    @MethodSource("testSourcesProvider")
    void solution(int expected, int[] input) throws InterruptedException {
        assertEquals(expected, solutionFirstPositive.solution(input));
    }

    private static Stream<Arguments> testSourcesProvider() {
        return Stream.of(
                Arguments.of(4, new int[]{1, 2, 3}),
                Arguments.of(1, new int[]{-1, -3}),
                Arguments.of(5, new int[]{1, 3, 6, 4, 1, 2, 3, 6, 4, 1, 2, 3, 6, 4, 1, 2, 3, 20, 4, 1, 2, 3, 6, 4, 1, 2, 3, 6, 4, 1, 2}),
                Arguments.of(151, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150})
        );
    }
}