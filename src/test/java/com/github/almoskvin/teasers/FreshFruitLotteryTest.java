package com.github.almoskvin.teasers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FreshFruitLotteryTest {

    FreshFruitLottery lottery = new FreshFruitLottery();

    @ParameterizedTest
    @MethodSource("testSourcesProvider")
    void foo(int expected, List<String> codeList, List<String> shoppingCart) {
        assertEquals(expected, lottery.foo(codeList, shoppingCart));
    }

    private static Stream<Arguments> testSourcesProvider() {
        return Stream.of(
                Arguments.of(1, List.of("apple", "apple", "banana", "anything", "banana"), List.of("orange", "apple", "apple", "banana", "anything", "banana")),
                Arguments.of(0, List.of("apple", "apple", "banana", "anything", "banana"), List.of("banana", "orange", "banana", "apple", "apple")),
                Arguments.of(0, List.of("apple", "apple", "banana", "anything", "banana"), List.of("apple", "banana", "apple", "banana", "orange", "banana"))
        );
    }
}