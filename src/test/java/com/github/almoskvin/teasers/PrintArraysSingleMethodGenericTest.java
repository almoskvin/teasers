package com.github.almoskvin.teasers;

import org.junit.jupiter.api.Test;

class PrintArraysSingleMethodGenericTest {

    PrintArraysSingleMethodGeneric printArraysSingleMethodGeneric = new PrintArraysSingleMethodGeneric();

    @Test
    void printArray() {
        printArraysSingleMethodGeneric.printArray(new Integer[]{11, 1, 8, 12, 14});
        printArraysSingleMethodGeneric.printArray(new String[]{"Hello", ",", "world", "!"});
    }
}