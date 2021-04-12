package com.github.almoskvin.teasers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class StudentClassSortingTest {

    StudentClassSorting sorting = new StudentClassSorting();

    @ParameterizedTest
    @MethodSource("methodSourceProvider")
    void sortStudents(List<StudentClassSorting.Student> unsorted, List<StudentClassSorting.Student> expected) {
        List<StudentClassSorting.Student> sortedStudents = sorting.sortStudents(new ArrayList<>(unsorted));
        Assertions.assertIterableEquals(expected, sortedStudents);
    }

    private static Stream<Arguments> methodSourceProvider() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                new StudentClassSorting.Student(33, "Rumpa", 3.68),
                                new StudentClassSorting.Student(85, "Ashis", 3.85),
                                new StudentClassSorting.Student(56, "Samiha", 3.75),
                                new StudentClassSorting.Student(19, "Samara", 3.75),
                                new StudentClassSorting.Student(22, "Fahim", 3.76)
                        ),
                        List.of(
                                new StudentClassSorting.Student(85, "Ashis", 3.85),
                                new StudentClassSorting.Student(22, "Fahim", 3.76),
                                new StudentClassSorting.Student(19, "Samara", 3.75),
                                new StudentClassSorting.Student(56, "Samiha", 3.75),
                                new StudentClassSorting.Student(33, "Rumpa", 3.68)
                        ))
        );
    }

}