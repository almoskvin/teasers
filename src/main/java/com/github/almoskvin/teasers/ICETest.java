package com.github.almoskvin.teasers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ICETest {
    public static long countMax(List<String> upRight) {
        // Write your code here
        int[][] grid = new int[100][100];
        int max = 0;
        long maxCount = 0L;
        for (String entry : upRight) {
            final String[] coordinates = entry.split(" ");
            final int y = Integer.parseInt(coordinates[0]);
            final int x = Integer.parseInt(coordinates[1]);
            if (x > grid.length) {
                final int[][] temp = grid;
                grid = Arrays.copyOf(temp, x * 2);
            }
            for (int i = 0; i < x; i++) {
                if (grid[i] == null) {
                    grid[i] = new int[y];
                }
                if (y > grid[i].length) {
                    final int[] temp = grid[i];
                    grid[i] = Arrays.copyOf(temp, y * 2);
                }
                for (int j = 0; j < y; j++) {
                    grid[i][j] += 1;
                    if (grid[i][j] > max) {
                        max = grid[i][j];
                        maxCount = 1L;
                    } else if (grid[i][j] == max) {
                        maxCount += 1;
                    }
                }
            }
        }
        return maxCount;
    }

    static int maxTickets(List<Integer> tickets) {
        int maxResult = 0;
        final int[] t = tickets.stream().mapToInt(i -> i).toArray();
        sort(t, t.length);
        List<Integer> sequence = new LinkedList<>();
        for (int value : t) {
            if (sequence.isEmpty() || sequence.get(sequence.size() - 1) == value || sequence.get(sequence.size() - 1) == value - 1) {
                sequence.add(value);
            } else {
                if (maxResult < sequence.size()) {
                    maxResult = sequence.size();
                }
                sequence.clear();
            }
        }
        return Math.max(maxResult, sequence.size());
    }

    static void sort(int[] arr, int n) {
        if (n <= 1) {
            return;
        }
        sort(arr, n - 1);
        int last = arr[n - 1];
        int j = n - 2;
        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = last;
    }
}
