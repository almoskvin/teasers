package com.github.almoskvin.teasers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumStringIntegersWithoutConvertingTest {

    private static Stream<Arguments> argumentSourceProvider() {
        return Stream.of(
                Arguments.of("121", "33", "154"),
                Arguments.of("456", "77", "533"),
                Arguments.of("0", "0", "0")
        );
    }

    @ParameterizedTest
    @MethodSource("argumentSourceProvider")
    void addStrings(String num1, String num2, String expected) {
        assertEquals(expected, SumStringIntegersWithoutConverting.addStrings(num1, num2));
    }
}