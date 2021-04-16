package com.github.almoskvin.teasers;

import java.util.List;
import java.util.Stack;

/**
 * A string containing only parentheses is balanced if the following is true: 1. if it is an empty string 2. if A and B are correct, AB is correct, 3. if A is correct, (A) and {A} and [A] are also correct.
 *
 * Examples of some correctly balanced strings are: "{}()", "[{()}]", "({()})"
 *
 * Examples of some unbalanced strings are: "{}(", "({)}", "[[", "}{" etc.
 *
 * Given a string, determine if it is balanced or not.
 */
public class StackBalancedString {
    public boolean isBalanced(String s) {
        final List<Character> startChars = List.of('{', '(', '[');
        final List<Character> finalChars = List.of('}', ')', ']');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (stack.isEmpty() || startChars.contains(c)) {
                stack.push(c);
                continue;
            }
            if (startChars.indexOf(stack.pop()) != finalChars.indexOf(c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
