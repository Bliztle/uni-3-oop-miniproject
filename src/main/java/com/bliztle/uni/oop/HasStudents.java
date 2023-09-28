package com.bliztle.uni.oop;

import java.util.HashSet;

public abstract class HasStudents {
    private HashSet<String> studentIds = new HashSet<>();

    public boolean addStudent(String studentId) {
        return studentIds.add(studentId);
    }

    public boolean hasStudent(String studentId) {
        return studentIds.contains(studentId);
    }

    public int studentCount() {
        return studentIds.size();
    }
}
