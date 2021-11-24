package com.github.almoskvin.teasers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ICETestTest {

    @Test
    void countMax() {
        Assertions.assertEquals(2, ICETest.countMax(List.of("2 3", "3 7", "4 1")));
    }

    @Test
    void maxTickets() {
        Assertions.assertEquals(3, ICETest.maxTickets(List.of(4, 13, 2, 3)));
    }
}