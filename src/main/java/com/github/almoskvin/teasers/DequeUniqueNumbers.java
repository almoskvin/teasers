package com.github.almoskvin.teasers;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * In this problem, you are given  integers. You need to find the maximum number of unique integers among all the possible contiguous subarrays of size .
 *
 * Note: Time limit is  second for this problem.
 *
 * Sample Input
 *
 * 6 3
 * 5 3 5 2 3 2
 * Sample Output
 *
 * 3
 * Explanation
 *
 * In the sample testcase, there are 4 subarrays of contiguous numbers.
 *
 * 5,3,5 - Has 2 unique numbers.
 *
 * 3,5,2 - Has 3 unique numbers.
 *
 * 5,2,3 - Has 3 unique numbers.
 *
 * 2,3,2 - Has 2 unique numbers.
 *
 * In these subarrays, there are 2,3,3,2  unique numbers, respectively. The maximum amount of unique numbers among all possible contiguous subarrays is 3.
 */
public class DequeUniqueNumbers {

    public int getMaxUniqueNumbers(int subarraySize, int[] input) {
        Deque<Integer> deque = new ArrayDeque<>(subarraySize);
        StopWatch timer = new StopWatch();
        timer.start();

        int maxUniques = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            // iterating here - imitation of consequently receiving values from stdin
            final int num = input[i];
            deque.addLast(num);
            set.add(num);
            if (i + 1 - subarraySize >= 0) {
                maxUniques = Math.max(maxUniques, set.size());
                final Integer first = deque.removeFirst();
                if (!deque.contains(first)) {
                    set.remove(first);
                }
            }
        }
        timer.stop();
        System.out.println(timer.getTime());
        return maxUniques;
    }
}
