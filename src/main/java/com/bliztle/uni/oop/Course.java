package com.bliztle.uni.oop;

public class Course extends HasStudents {

    private String id;

    public Course(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public int hashCode() {
        System.out.println(id + " -> " + id.hashCode() + " (Course)");
        return id.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Course) {
            Course course = (Course) obj;
            return id.equals(course.id);
        }
        return false;
    }
}
