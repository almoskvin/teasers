package com.github.almoskvin.teasers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class UniqueNamesHashSetTest {

    @ParameterizedTest
    @MethodSource("testSourcesProvider")
    void getUniqueNamesNumberEachIncome(int entries, String[] pairLeft, String[] pairRight, int[] expected) {
        UniqueNamesHashSet uniqueNamesHashSet = new UniqueNamesHashSet();
        Assertions.assertArrayEquals(expected, uniqueNamesHashSet.getUniqueNamesNumberEachIncome(entries, pairLeft, pairRight));
    }

    private static Stream<Arguments> testSourcesProvider() {
        return Stream.of(
                Arguments.of(5, new String[]{"john", "john", "john", "mary", "mary"}, new String[]{"tom", "mary", "tom", "anna", "anna"}, new int[]{1, 2, 2, 3, 3})
        );
    }
}