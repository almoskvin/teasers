package com.github.almoskvin.teasers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionParseLsOutputTest {

    SolutionParseLsOutput solution = new SolutionParseLsOutput();

    @Test
    void testSolution() {
        String s = "  root r-x delete-this.xls\n  root r-- bug-report.pdf\n  root r-- doc.xls\n  root r-- podcast.flac\n alice r-- system.xls\n  root --x invoices.pdf\n admin rwx SETUP.PY";
        assertEquals("7", solution.solution(s));
    }
}