package com.github.almoskvin.teasers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class DequeUniqueNumbersTest {

    DequeUniqueNumbers deque = new DequeUniqueNumbers();

    @ParameterizedTest
    @MethodSource("testSourcesProvider")
    void getMaxUniqueNumbersTestEasy(int expected, int subarraySize, int[] input) {
        Assertions.assertEquals(expected, deque.getMaxUniqueNumbers(subarraySize, input));
    }

    private static Stream<Arguments> testSourcesProvider() {
        return Stream.of(
                Arguments.of(
                        1,
                        3,
                        new int[]{2, 2, 2, 2, 2, 2}
                ), Arguments.of(
                        3,
                        3,
                        new int[]{5, 3, 5, 2, 3, 2}
                ), Arguments.of(
                        3,
                        4,
                        new int[]{5, 3, 5, 2, 3, 2, 3, 2}
                ));
    }

    @Test
    void getMaxUniqueNumbersTestHeavy() {
        try {
            Path path = Paths.get(this.getClass().getClassLoader().getResource("input100000numbers.csv").toURI());
            final List<String> lines = Files.readAllLines(path);
            final int[] commonAttributes = Arrays.stream(lines.get(0).split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int expected = commonAttributes[2];
            int subarraySize = commonAttributes[1];
            final int[] input = Arrays.stream(lines.get(1).split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Assertions.assertEquals(expected, deque.getMaxUniqueNumbers(subarraySize, input));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}