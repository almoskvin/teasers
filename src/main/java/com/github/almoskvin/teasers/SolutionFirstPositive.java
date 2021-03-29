package com.github.almoskvin.teasers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Write a function:
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * Given A = [1, 2, 3], the function should return 4.
 * Given A = [−1, −3], the function should return 1.
 * Write an efficient algorithm for the following assumptions:
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 */

public class SolutionFirstPositive {

    public int solution(int[] A) throws InterruptedException {
        List<Integer> list = Arrays.stream(A)
                .parallel()
                .filter(entry -> entry > 0)
                .boxed()
                .collect(Collectors.toList());
        if (list.size() == 0 || Collections.max(list) < 1) {
            return 1;
        }
        for (int i = 1; i <= Collections.max(list) + 1; i++) {
            //TODO: improve this part
            Thread.sleep(500);
            if (!list.contains(i)) {
                return i;
            }
        }
        return 1;
    }
}
