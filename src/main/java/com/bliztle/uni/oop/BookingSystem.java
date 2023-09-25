package com.bliztle.uni.oop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class BookingSystem {

    private static Scanner scanner;

    private HashSet<String> rooms = new HashSet<>();
    private HashSet<Group> groups = new HashSet<>();
    private CourseSet courses = new CourseSet();
    private ArrayList<Reservation> reservations = new ArrayList<>();

    /**
     * Adds a new room to the system, if it does not already exist.
     */
    private void addRoom() {
        System.out.print("Enter room id: ");
        String roomId = scanString();
        if (rooms.add(roomId))
            System.out.println("Room " + roomId + " added!");
        else
            System.out.println("Room already exists!");
    }

    /**
     * Adds a new group to the system, if it does not already exist.
     * 
     * Contains built-in validation for the group's course and students,
     * ensuring no student is signed up for more than 5 groups,
     * or that a student is not already in a group for the course.
     */
    private void addGroup() {
        if (courses.size() == 0) {
            printMissing("group", "courses");
            return;
        }

        System.out.print("Enter course id: ");
        String courseId = scanString();
        if (!courses.contains(new Course(courseId))) {
            System.out.println("Course " + courseId + " does not exist!");
            return;
        }

        System.out.print("Enter group id: ");
        String groupId = scanString();
        Group group = new Group(groupId, courseId);
        if (groups.contains(group)) {
            System.out.println("Group " + groupId + " already exists!");
            return;
        }

        int addedStudents = 0;
        do {
            System.out.print("Enter student id (q to exit): ");
            String studentId = scanString();
            if (studentId.equals("q"))
                break;

            if (courses.hasStudent(courseId, studentId)) {
                System.out.println("Student " + studentId + " is already in a group for course " + courseId + "!");
                continue;
            }

            if (courses.countCoursesByStudent(studentId) >= 5) {
                System.out.println("Student " + studentId + " is already in 5 groups!");
                continue;
            }

            group.addStudent(studentId);
        } while (addedStudents < Group.MAX_STUDENTS);

        if (group.studentCount() > 0)
            groups.add(group);
        else
            System.out.println("Group " + groupId + " is empty!");

    }

    /**
     * Adds a new course to the system, if it does not already exist.
     */
    private void addCourse() {
        System.out.println("Existing courses: " + courses);
        System.out.println("Enter course id: ");
        String courseId = scanString();
        if (courses.add(new Course(courseId)))
            System.out.println("Course " + courseId + " added!");
        else
            System.out.println("Course already exists!");
    }

    private void addReservation() {

        ArrayList<String> missing = new ArrayList<>();
        if (rooms.size() == 0)
            missing.add("rooms");
        if (groups.size() == 0)
            missing.add("groups");

        if (missing.size() > 0) {
            printMissing("reservation", missing);
            return;
        }

        if (courses.size() == 0) {
            System.out.println(
                    "There are no courses in the system!\nPlease add a course before attempting to add a group.");
            return;
        }

        System.out.println("Adding a reservation...");
    }

    /**
     * Prints a message to the user, informing them of missing entities.
     * 
     * @param context The context of the missing entities.
     * @param missing The missing entities.
     */
    private void printMissing(String context, String missing) {
        // printMissing(context, new ArrayList<String>(List.of(missing)));
        printMissing(context, List.of(missing));
    }

    /**
     * Prints a message to the user, informing them of missing entities.
     * 
     * @param context The context of the missing entities.
     * @param missing The missing entities.
     */
    private void printMissing(String context, List<String> missing) {
        System.out.println("There are no " + String.join(" or ", missing) + " in the system!");
        boolean plural = missing.get(0).endsWith("s");
        System.out.println("Please add " + (plural ? "" : "a ") + String.join(" and ", missing)
                + " before attempting to add a " + context);
    }

    /**
     * Gets an integer from the user.
     * 
     * @returns The integer.
     */
    private int scanInt() {
        System.out.print("> ");
        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.println("");
        return option;
    }

    /**
     * Gets a string from the user.
     * 
     * @returns The string.
     */
    private String scanString() {
        System.out.print("> ");
        String option = scanner.nextLine();
        System.out.println("\nscanned: \"" + option + "\"\n");
        return option;
    }

    /**
     * Shows the options to the user.
     */
    private void showOptions() {
        System.out.println("""

                1) Add a room
                2) Add a group
                3) Add a course
                4) Add a reservation

                5) exit\n""");
        // 6. Add student(s) to a group
    }

    /**
     * Interacts with the user, showing options and getting input.
     * 
     * @returns Whether the system should continue running.
     */
    private boolean interact() {
        showOptions();
        int option = scanInt();
        switch (option) {
            case 1 -> addRoom();
            case 2 -> addGroup();
            case 3 -> addCourse();
            case 4 -> addReservation();
            case 5 -> {
                return false;
            }
            default -> System.out.println("Invalid option!");
        }
        return true;
    }

    /** Display introduction promt */
    private static void introduction() {
        System.out.println("""
                Booking system started!
                There are currently no rooms, courses, groups, or reservations saved in the system.""");
    }

    /** Say goodbye */
    private static void goodbye() {
        System.out.println("""
                Thanks for using the system!
                Shutting down...""");
    }

    /**
     * Starts the booking system.
     * 
     * Handles opening and closing the input scanner, to ensure it is not left open,
     * leaking memory.
     */
    public static void start() {
        BookingSystem bs = new BookingSystem();
        scanner = new Scanner(System.in);
        scanner.useDelimiter(System.lineSeparator());
        introduction();
        while (bs.interact())
            ;
        goodbye();
        scanner.close();
    }
}
