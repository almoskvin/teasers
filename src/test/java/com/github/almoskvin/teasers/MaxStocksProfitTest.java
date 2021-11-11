package com.github.almoskvin.teasers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class MaxStocksProfitTest {

    MaxStocksProfit profit = new MaxStocksProfit();

    @ParameterizedTest
    @MethodSource("testSourcesProvider")
    void getMaxProfit(List<Long> prices, Long result) {
        Assertions.assertEquals(result, profit.getMaxProfit(prices));
    }

    private static Stream<Arguments> testSourcesProvider() {
        return Stream.of(
                Arguments.of(List.of(11L, 1L, 8L, 12L, 14L, 5L, 4L, 19L), 18L),
                Arguments.of(List.of(11L, 1L, 30L, 12L, 14L, 5L, 4L, 19L, 15L, 10L, 22L), 21L),
                Arguments.of(List.of(11L, 5L, 8L, 12L, 14L, 5L, 4L, 3L), 0L)
        );
    }
}