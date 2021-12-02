package com.github.almoskvin.teasers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class HouseRobberTest {

    private static Stream<Arguments> argumentSourceProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1}, 4),
                Arguments.of(new int[]{2, 1, 1, 2}, 4),
                Arguments.of(new int[]{1, 9, 4, 3, 9, 2}, 18),
                Arguments.of(new int[]{2, 7, 9, 3, 1}, 12)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentSourceProvider")
    void rob(int[] nums, int expected) {
        Assertions.assertEquals(expected, HouseRobber.rob(nums));
    }
}