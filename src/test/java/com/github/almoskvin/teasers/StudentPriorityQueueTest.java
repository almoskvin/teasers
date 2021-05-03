package com.github.almoskvin.teasers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class StudentPriorityQueueTest {

    StudentPriorityQueue queue = new StudentPriorityQueue();

    private static Stream<Arguments> methodSourceProvider() {
        return Stream.of(
                Arguments.of(
                        List.of("ENTER John 3.75 50",
                                "ENTER Mark 3.8 24",
                                "ENTER Shafaet 3.7 35",
                                "SERVED",
                                "SERVED",
                                "ENTER Samiha 3.85 36",
                                "SERVED",
                                "ENTER Ashley 3.9 42",
                                "ENTER Maria 3.6 46",
                                "ENTER Anik 3.95 49",
                                "ENTER Dan 3.95 50",
                                "SERVED"),
                        List.of("Dan",
                                "Ashley",
                                "Shafaet",
                                "Maria")
                )
        );
    }

    @ParameterizedTest
    @MethodSource("methodSourceProvider")
    void operateQueue(List<String> input, List<String> expected) {
        final List<String> result = queue.operateQueue(input);
        Assertions.assertLinesMatch(result, expected);
    }
}