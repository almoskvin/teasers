package com.github.almoskvin.teasers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class SolutionTheBiggestWithFive {

    /**
     * Write a function returning a maximum number which occurs if you add 5 to the string representation of N.
     *
     * Example:
     * Should return 5268 if N = 268
     * Should return 6750 if N = 670
     * Should return 50 if N = 0
     * Should return -5999 if N = -999
     *
     * @param N base number
     * @return int
     */
    public int solution(int N) {
        String stringN = String.valueOf(N);
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < stringN.length(); i++) {
            StringBuilder numberBuilder = new StringBuilder();
            if (stringN.charAt(i) == '-') {
                continue;
            }
            numberBuilder.append(stringN, 0, i)
                    .append("5")
                    .append(stringN.substring(i));
            resultList.add(numberBuilder.toString());
        }

        Stream<Integer> integerStream = resultList
                .parallelStream()
                .map(Integer::valueOf);

        return integerStream
                .max(Integer::compareTo)
                .orElse(0);
    }
}
