package com.github.almoskvin.teasers;

/**
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * <p>
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 * <p>
 * Example 3:
 * Input: s = "a"
 * Output: "a"
 * <p>
 * Example 4:
 * Input: s = "ac"
 * Output: "a"
 * <p>
 * Constraints:
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters.
 */
public class StringLongestPalindrome {
    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        // goes from longer substrings to the shorter ones so the first palindrome found will be our guys
        for (int i = s.length(); i >= 0; i--) {
            for (int j = 0; j <= s.length() - i; j++) {
                String seq = s.substring(j, j + i);
                if (isPalindrome(seq)) {
                    return seq;
                }
            }
        }
        return "";
    }

    private static boolean isPalindrome(String s) {
        int forward = 0;
        int backward = s.length() - 1;
        while (backward > forward) { // inspect the string from the both ends one-by-one char
            final char charF = s.charAt(forward++);
            final char charB = s.charAt(backward--);
            if (charB != charF) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeFromInt(int x) {
        final String xStr = String.valueOf(x); //Follow up: Could you solve it without converting the integer to a string?
        for (int i = 0; i < xStr.length() / 2; i++) {
            if (xStr.charAt(i) != xStr.charAt(xStr.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
