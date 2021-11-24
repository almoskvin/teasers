package com.github.almoskvin.teasers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class StringLongestPalindromeTest {

    @ParameterizedTest
    @MethodSource("argumentSourceProvider")
    void longestPalindrome(String input, String expected) {
        Assertions.assertEquals(expected, StringLongestPalindrome.longestPalindrome(input));
    }

    private static Stream<Arguments> argumentSourceProvider() {
        return Stream.of(
                Arguments.of("babad", "bab"),
                Arguments.of("cbbd", "bb"),
                Arguments.of("a", "a"),
                Arguments.of("ac", "a"),
                Arguments.of("bb", "bb")
        );
    }
}