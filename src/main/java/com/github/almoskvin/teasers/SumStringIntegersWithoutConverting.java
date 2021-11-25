package com.github.almoskvin.teasers;

public class SumStringIntegersWithoutConverting {

    /**
     * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
     * <p>
     * You must solve the problem without using any built-in library for handling large integers (such as BigInteger).
     * You must also not convert the inputs to integers directly.
     * <p>
     * Constraints:
     * <p>
     * 1 <= num1.length, num2.length <= 10^4
     * num1 and num2 consist of only digits.
     * num1 and num2 don't have any leading zeros except for the zero itself.
     */
    public static String addStrings(String num1, String num2) {
        final int num1Length = num1.length();
        final int num2Length = num2.length();

        if (num1Length > num2Length) {
            num2 = addLeadingZeros(num2, num1Length - num2Length);
        } else if (num1Length < num2Length) {
            num1 = addLeadingZeros(num1, num2Length - num1Length);
        }
        int addOn = 0;
        StringBuilder result = new StringBuilder();

        for (int i = num1.length() - 1; i >= 0; i--) {
            int num1Number = Integer.parseInt(num1.substring(i, i + 1));
            int num2Number = Integer.parseInt(num2.substring(i, i + 1));
            int comp = num1Number + num2Number + addOn;
            addOn = comp >= 10 ? 1 : 0;
            result.insert(0, (comp >= 10 ? (comp - 10) : comp));
        }
        if (addOn == 1) {
            result.insert(0, "1");
        }
        return result.toString();
    }

    private static String addLeadingZeros(String s, int length) {
        StringBuilder builder = new StringBuilder(s);
        for (int i = 0 ; i < length; i++) {
            builder.insert(0, 0);
        }
        return builder.toString();
    }
}
