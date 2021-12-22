package com.github.almoskvin.teasers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class VersionComparatorTest {

    private static Stream<Arguments> argumentSourceProvider() {
        return Stream.of(
                Arguments.of("0.1", "1.1", -1),
                Arguments.of("1.2.9.9.9.9", "1.2.9.9.8.9", 1),
                Arguments.of("15.10.1", "15.10.1", 0),
                Arguments.of("1.3", "1.3.4", -1),
                Arguments.of("1.3.0", "1.3", 1)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentSourceProvider")
    void solution(String v1, String v2, int expected) {
        Assertions.assertEquals(expected, VersionComparator.compare(v1, v2));
    }
}