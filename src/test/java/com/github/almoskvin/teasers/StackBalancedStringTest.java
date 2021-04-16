package com.github.almoskvin.teasers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StackBalancedStringTest {

    StackBalancedString stackBalancedString = new StackBalancedString();

    @ParameterizedTest
    @ValueSource(strings = {"{}()", "({()})", "[{()}]{}", "({}){}()[]"})
    void isBalancedTrue(String input) {
        Assertions.assertTrue(stackBalancedString.isBalanced(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"{}(", "][", "({)}", "[[", "]]", "}{"})
    void isBalancedFalse(String input) {
        Assertions.assertFalse(stackBalancedString.isBalanced(input));
    }
}