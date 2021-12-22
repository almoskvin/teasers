package com.github.almoskvin.teasers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BankBalancesRequestsTest {

    private static Stream<Arguments> sourceProvider() {
        return Stream.of(
                Arguments.of(new int[]{10, 100, 20, 50, 30},
                        new String[]{"withdraw 2 10", "transfer 5 1 20", "deposit 5 20", "transfer 3 4 15"},
                        new int[]{30, 90, 5, 65, 30}),
                Arguments.of(new int[]{20, 1000, 500, 40, 90},
                        new String[]{"deposit 3 400", "transfer 1 2 30", "withdraw 4 50"},
                        new int[]{-2})
        );
    }

    @ParameterizedTest
    @MethodSource("sourceProvider")
    void solution(int[] balances, String[] requests, int[] expected) {
        final int[] solution = BankBalancesRequests.solution(balances, requests);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertEquals(expected[i], solution[i]);
        }
    }
}