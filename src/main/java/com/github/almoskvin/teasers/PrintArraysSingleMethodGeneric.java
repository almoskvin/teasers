package com.github.almoskvin.teasers;

import java.util.Arrays;

public class PrintArraysSingleMethodGeneric {

    /**
     * Let's say you have an integer array and a string array. <br>
     * You have to write a single method printArray that can print all the elements of both arrays. <br>
     * The method should be able to accept both integer arrays or string arrays.
     *
     * @param a   Integer or String array
     * @param <T> array type
     */
    public <T> void printArray(T[] a) {
        Arrays.stream(a).forEach(System.out::println);
    }
}
