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

`start` is static as the only entry point of the system, and `introduction` and `goodbye` are static as they are only called from `start`. This architecture is chosen as no outside classes need to interact with the system, so no instance is needed outside of the class. Instead, `start` creates a new instance from which to run the system. This allows future systems to start up without having to restart the program, or otherwise manually clean up.

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
