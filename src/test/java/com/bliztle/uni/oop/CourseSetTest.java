package com.bliztle.uni.oop;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CourseSetTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CourseSetTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(CourseSetTest.class);
    }

    /** Ensure Set properties hold with regards to ID */
    public void testAdd() {
        CourseSet courses = new CourseSet();
        assertTrue(courses.add(new Course("CS101")));
        assertTrue(courses.add(new Course("CS102")));

        assertFalse(courses.add(new Course("CS101")));
    }
}
