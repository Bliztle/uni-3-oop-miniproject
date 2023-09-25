package com.bliztle.uni.oop;

public class Group extends HasStudents {

    public static final int MAX_STUDENTS = 6;

    private final String id;

    // Course id is not yet relevant to the system
    private final String courseId;

    public Group(String id, String courseId) {
        this.id = id;
        this.courseId = courseId;
    }

    public int hashCode() {
        return (id).hashCode();
    }
}
