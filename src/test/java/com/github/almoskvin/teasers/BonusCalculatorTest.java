package com.github.almoskvin.teasers;

import org.apache.commons.lang3.time.StopWatch;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusCalculatorTest {

    public static StopWatch stopWatch = new StopWatch();

    @ParameterizedTest
    @MethodSource("testSourcesProvider")
    void calculateBonusSizeTest(List<Integer> acc, int payees, int expectedBonus) {
        assertEquals(expectedBonus, calculateBonusLogTime(acc, payees));
    }

    private int calculateBonusLogTime(List<Integer> acc, int payees) {
        stopWatch.start();
        final int result = BonusCalculator.calculateBonusSize(acc, payees);
        stopWatch.stop();
        System.out.println(String.format("Calculation has taken %d ms", stopWatch.getTime()));
        stopWatch.reset();
        return result;
    }

    private static Stream<Arguments> testSourcesProvider() {
        return Stream.of(
                Arguments.of(
                        List.of(16, 18, 7, 45),
                        10,
                        7
                ), Arguments.of(
                        List.of(199, 453, 220, 601),
                        6,
                        200
                ), Arguments.of(
                        List.of(99, 1),
                        100,
                        1
                ), Arguments.of(
                        List.of(98, 1),
                        100,
                        0
                ), Arguments.of(
                        List.of(10000000, 10000000),
                        100000,
                        200
                ));
    }
}