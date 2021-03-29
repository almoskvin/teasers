package com.github.almoskvin.teasers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ParagraphTest {

    @ParameterizedTest
    @MethodSource("testSourcesProvider")
    void changeFormat(String expected, String provided) {
        Assertions.assertEquals(expected, Paragraph.changeFormat(provided));
    }

    private static Stream<Arguments> testSourcesProvider() {
        return Stream.of(
                Arguments.of("Please quote your policy number: 112/39/8552", "Please quote your policy number: 112-39-8552"),
                Arguments.of("Your policy number 112/39/8552. Please quote it", "Your policy number 112-39-8552. Please quote it"),
                Arguments.of("112/39/8552", "112-39-8552")
        );
    }
}