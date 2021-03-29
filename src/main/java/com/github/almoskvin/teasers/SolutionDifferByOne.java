package com.github.almoskvin.teasers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class SolutionDifferByOne {

    /**
     * Check if the input array contains consequent two numbers with +1 difference between them
     * @param A array oif numbers
     * @return true if there is two numbers in a row that differentiate only by 1, otherwise return false
     */
    public boolean solution(int[] A) {
        List<Integer> modifiedList = Arrays.stream(A)
                .boxed()
                .collect(Collectors.toList());
        return Arrays.stream(A)
                .parallel()
                .anyMatch(entry -> modifiedList.contains(entry + 1) || modifiedList.contains(entry - 1));
    }
}
