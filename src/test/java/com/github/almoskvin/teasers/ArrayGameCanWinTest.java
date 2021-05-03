package com.github.almoskvin.teasers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ArrayGameCanWinTest {

    private static Stream<Arguments> methodSourceProvider() {
        return Stream.of(
                Arguments.of(
                        3, new int[]{0, 0, 0, 0, 0}, true
                ),
                Arguments.of(
                        5, new int[]{0, 0, 0, 1, 1, 1}, true
                ),
                Arguments.of(
                        3, new int[]{0, 0, 1, 1, 1, 0}, false
                ),
                Arguments.of(
                        5, new int[]{0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1}, true
                ),
                Arguments.of(
                        5, new int[]{0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1}, true
                ),
                Arguments.of(
                        5, new int[]{0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1}, false
                ),
                Arguments.of(
                        1, new int[]{0, 1, 0}, false
                ),
                Arguments.of(
                        95, new int[]{0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1}, true
                )
        );
    }

    @ParameterizedTest
    @MethodSource("methodSourceProvider")
    void canWinTest(int leap, int[] game, boolean expected) {
        final boolean result = ArrayGameCanWin.canWin(leap, game);
        Assertions.assertEquals(expected, result);
    }
}