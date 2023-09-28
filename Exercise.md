# Miniproject

## Self-study 1

### 1.1

Here is the list of most fields in `BookingSystem`

```java
private HashSet<String> rooms = new HashSet<>();
private HashSet<Group> groups = new HashSet<>();
private CourseSet courses = new CourseSet();
private ArrayList<Reservation> reservations = new ArrayList<>();
```

They are all private in accordance with OOP principles of encapsulation, as defined in the OOP course. As they all belong to a single booking system, they are also kept as instance fields, instead of class fields.

The only static field is `Scanner` used for user input, as the static methods of the class also needs access to it.

```java
private static Scanner scanner
private static void introduction()
private static void goodbye()
private static void start()
```

`start` is static as the only entry point of the system, and `introduction` and `goodbye` as the state of the system has no relevance to their behaviour. This architecture is chosen as no outside classes need to interact with the system, so no instance is needed outside of the class. Instead, `start` creates a new instance from which to run the system. This allows future systems to start up without having to restart the program, or otherwise manually clean up.

as for interaction, that is handled by the following methods, which are all private as all interaction is handled by the system itself.

```java
private boolean interact()
private void showOptions()
private int getOption()
```

The same goes for the rest of the methods defined, which all corresponds to the options in the menu.

```java
private void addRoom()
private void addGroup()
private void addCourse()
private void addReservation()
```

### 1.2

`HashSet` is used explicitly for `rooms` and `groups`, and through inheritance in the custom `CourseSet` class. This is done as all rooms, groups and courses should be unique, and that functionality is easily provided by `HashSet`. CourseSet uses inheritance to add extra logic for handling queries on course data.

The `Group` and `Course` classes both inherit from a `HasStudents` class, as they both need logic pertaining to adding, counting and checking students. This is done to allow easier extension of the system.

`reservations` is an `ArrayList` as reservations need to be expandable, but do not have to be unique.

### 1.3

I have chosen the core classes of the system, other than `BookingSystem`, to be `Group`, `Course`, `Reservation` and `Room`, as these represent the main objects relevant to the system. `CourseSet` is also included, but is not a core class, but rather a collection of helper functions for searching the set of courses.

### 1.4

While defining these classes, the previously mentioned `HasStudents` class was indentified as common functionality between `Group` and `Course`. This was then extracted into a superclass, which both classes now inherit from.

```java
public abstract class HasStudents {
    private HashSet<String> studentIds = new HashSet<>();

    public boolean addStudent()

    public boolean hasStudent()

    public int studentCount()
}
```

As all of these are dependent on the current state of the object, they are all instance methods.

`hasStudents` consumers:

```java
public class Group extends HasStudents {

    public static final int MAX_STUDENTS = 6;
    private final String id;
    // Course id is not yet relevant to the system
    private final String courseId;
    public Group(String id, String courseId)
    public int hashCode()
    public boolean equals(Object obj)
}
```

`MAX_STUDENTS` is static and final since the constant maximum group size is defined in the exercise. `id` and `courseId` are final as they should not be changed after creation. It is important `id` is static as it is used in both `hashCode` and `equals`.

The rest of the methods are instance methods as they are dependent on the current state of the object.

The same logic goes for `Course` and `CourseSet` with regards to class vs instance methods / fields:

```java
public class Course extends HasStudents {

    private String id;
    public Course(String id)
    public String getId()
    public int hashCode()
    public boolean equals(Object obj)
}
```

```java
public class Room {
    private final String id;
    public Room(String id)
    public String getId()
    public int hashCode()
    public boolean equals(Object obj)
}
```

```java
public class CourseSet extends HashSet<Course> {

    public boolean addStudent(String courseId, String studentId)
    public boolean hasStudent(String courseId, String studentId)
    public int countCoursesByStudent(String studentId);
    // toString exists for debugging purposes
    public String toString()
}
```

### 1.5

These were already shown in `1.4`, but are added to be used for checking if a group or course already exists in the system.

### 1.6

It has been added.
