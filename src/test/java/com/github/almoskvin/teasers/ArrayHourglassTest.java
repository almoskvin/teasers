package com.github.almoskvin.teasers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ArrayHourglassTest {

    ArrayHourglass arrayHourglass = new ArrayHourglass();

    private static Stream<Arguments> methodSourceProvider() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                new int[]{1, 1, 1, 0, 0, 0},
                                new int[]{0, 1, 0, 0, 0, 0},
                                new int[]{1, 1, 1, 0, 0, 0},
                                new int[]{0, 0, 2, 4, 4, 0},
                                new int[]{0, 0, 0, 2, 0, 0},
                                new int[]{0, 0, 1, 2, 4, 0}
                        },
                        19
                ),
                Arguments.of(
                        new int[][]{
                                new int[]{-1, -1, 0, -9, -2, -2},
                                new int[]{-2, -1, -6, -8, -2, -5},
                                new int[]{-1, -1, -1, -2, -3, -4},
                                new int[]{-1, -9, -2, -4, -4, -5},
                                new int[]{-7, -3, -3, -2, -9, -9},
                                new int[]{-1, -3, -1, -2, -4, -5}
                        },
                        -6
                )
        );

    }

    @ParameterizedTest
    @MethodSource("methodSourceProvider")
    void getMaxHourglass(int[][] array, int expected) {
        final int maxHourglass = arrayHourglass.getMaxHourglass(array);
        Assertions.assertEquals(expected, maxHourglass);
    }
}