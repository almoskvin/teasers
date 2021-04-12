package com.github.almoskvin.teasers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.List;

public class StudentClassSorting {
    @Data
    @AllArgsConstructor
    static class Student {
        private int id;
        private String fname;
        private double cgpa;
    }

    /**
     * Sort a list of students by CGPA, then (if the same) by Name, then (if the same) by ID. ID is unique.
     *
     * @param students list of students
     * @return sorted list
     */
    public List<Student> sortStudents(List<Student> students) {
        Comparator<Student> studentComparator = Comparator.comparingDouble(Student::getCgpa)
                .reversed()
                .thenComparing(Student::getFname)
                .thenComparingInt(Student::getId);
        students.sort(studentComparator);
        return students;
    }
}
