package com.github.almoskvin.teasers;

/**
 * An hourglass in an array is a portion shaped like this:
 * a b c
 * d
 * e f g
 * ---
 * Sample Input (exactly 6 X 6)
 * <p>
 * 1 1 1 0 0 0
 * 0 1 0 0 0 0
 * 1 1 1 0 0 0
 * 0 0 2 4 4 0
 * 0 0 0 2 0 0
 * 0 0 1 2 4 0
 * <p>
 * Sample Output
 * <p>
 * 19
 * <p>
 * Explanation
 * <p>
 * The hourglass which has the largest sum is:
 * <p>
 * 2 4 4
 * 2
 * 1 2 4
 * <p>
 * return - the largest sum among all the hourglasses in the array.
 */
public class ArrayHourglass {
    public int getMaxHourglass(int[][] arr) {
        int max = -63; // the minimum number the sum can be (-9 * 7)
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                final int hourglass = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                max = Math.max(max, hourglass);
            }
        }
        return max;
    }
}
