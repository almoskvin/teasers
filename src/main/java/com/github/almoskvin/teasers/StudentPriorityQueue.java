package com.github.almoskvin.teasers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;


public class StudentPriorityQueue {

    public StudentPriorityQueue() {
        queue = new PriorityQueue<>(comparator);
    }

    enum EventType {ENTER, SERVED}

    private PriorityQueue<Student> queue;
    Comparator<Student> comparator = Comparator.comparingDouble(Student::getCGPA).reversed()
            .thenComparing(Student::getName)
            .thenComparingInt(Student::getId);

    static class Student {
        int id;
        String name;
        double CGPA;

        public Student() {
        }

        public Student(int id, String name, double CGPA) {
            this.id = id;
            this.name = name;
            this.CGPA = CGPA;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getCGPA() {
            return CGPA;
        }

        public void setCGPA(double CGPA) {
            this.CGPA = CGPA;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", CGPA=" + CGPA +
                    '}';
        }
    }

    /**
     * Method puts students {@link StudentPriorityQueue.Student} in a priority queue and removes them by the prioroty using comparator: <br>
     * 1) The student having the highest Cumulative Grade Point Average (CGPA) is served first. <br>
     * 2) Any students having the same CGPA will be served by name in ascending case-sensitive alphabetical order.<br>
     * 3) Any students having the same CGPA and name will be served in ascending order of the id.
     *
     * @param events list of events consisting of ENTER with student details to be entered or SERVE meaning a student in priority must be removed from the queue
     * @return list of student names persisting in the queue after all the events applied
     */
    public List<String> operateQueue(List<String> events) {
        for (String event : events) {
            final String[] s = event.split(" ");
            final String eventType = s[0];
            if (EventType.valueOf(eventType) == EventType.SERVED) {
                queue.poll();
            } else if (EventType.valueOf(eventType) == EventType.ENTER) {
                Student student = new Student(Integer.parseInt(s[3]), s[1], Double.parseDouble(s[2]));
                queue.offer(student);
            }
        }
        if (queue.isEmpty()) {
            return Collections.singletonList("EMPTY");
        }
        return queue.stream()
                .sorted(comparator) //somehow in one case the order of elements was wrong in the queue - re-sort it with the same comparator fixes it.
                .map(Student::getName)
                .collect(Collectors.toList());
    }
}
