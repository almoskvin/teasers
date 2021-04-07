package com.github.almoskvin.teasers;

import java.util.HashSet;

/**
 * Given two arrays of names, where pairLeft[i] + pairRight[i] produces a pair,<br>
 * return an array of numbers of unique pairs of names, for each entry of pair arrays, starting from 0.
 */
public class UniqueNamesHashSet {
    public int[] getUniqueNamesNumberEachIncome(int entries, String[] pairLeft, String[] pairRight) {
        int[] result = new int[entries];
        HashSet<String> nameSet = new HashSet<>();
        for (int i = 0; i < entries; i++) {
            nameSet.add(String.join(" ", pairLeft[i], pairRight[i]));
            result[i] = nameSet.size();
        }
        return result;
    }
}
