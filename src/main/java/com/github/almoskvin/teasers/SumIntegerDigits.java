package com.github.almoskvin.teasers;

import java.util.Arrays;
import java.util.stream.Stream;

public class SumIntegerDigits {
    static class Tree<T> {
        Tree(T x) {
            value = x;
        }

        public Tree(T value, Tree<T> left, Tree<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        T value;
        Tree<T> left;
        Tree<T> right;
    }

    public static String[] solution(Tree<Integer> t) {
        return traverse(t, true);
    }

    public static String[] traverse(Tree<Integer> t, boolean isHeadNode) {
        if (t.left == null && t.right == null) {
            return t.value == null ? new String[]{} : new String[]{"->" + t.value.toString()};
        }

        final String[] strings = Stream.concat(Arrays.stream(traverse(t.left, false)), Arrays.stream(traverse(t.right, false)))
                .toArray(String[]::new);
        for (int i = 0; i < strings.length; i++) {
            strings[i] = (isHeadNode ? t.value.toString() : "->" + t.value.toString()) + strings[i];
        }
        return strings;
    }

}
