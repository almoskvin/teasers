package com.github.almoskvin.teasers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArraySortComparatorTest {

    @Test
    void compare() {
        ArraySortComparator.Player[] unsorted = new ArraySortComparator.Player[]{
                new ArraySortComparator.Player("amy", 100),
                new ArraySortComparator.Player("david", 100),
                new ArraySortComparator.Player("heraldo", 50),
                null,
                new ArraySortComparator.Player("aakansha", 75),
                new ArraySortComparator.Player("aleksa", 150)
        };
        ArraySortComparator.Player[] sorted = new ArraySortComparator.Player[]{
                null,
                new ArraySortComparator.Player("aleksa", 150),
                new ArraySortComparator.Player("amy", 100),
                new ArraySortComparator.Player("david", 100),
                new ArraySortComparator.Player("aakansha", 75),
                new ArraySortComparator.Player("heraldo", 50)
        };

        ArraySortComparator.Player[] actual = new ArraySortComparator().compare(unsorted);
        assertArrayEquals(sorted, actual);
    }
}