package com.bliztle.uni.oop;

import java.util.HashSet;

public class CourseSet extends HashSet<Course> {

    public boolean addStudent(String courseId, String studentId) {
        for (Course course : this) {
            if (course.getId().equals(courseId)) {
                return course.addStudent(studentId);
            }
        }
        return false;
    }

    public boolean hasStudent(String courseId, String studentId) {
        for (Course course : this) {
            if (course.getId().equals(courseId)) {
                return course.hasStudent(studentId);
            }
        }
        return false;
    }

    public int countCoursesByStudent(String studentId) {
        int count = 0;
        for (Course course : this) {
            if (course.hasStudent(studentId)) {
                count++;
            }
        }
        return count;
    }

    public String toString() {
        String result = "";
        for (Course course : this) {
            result += course.getId() + " ";
        }
        return result;
    }
}
