# LearnTrack – Student & Course Management System

---

## Project Description

LearnTrack is a console-based Student & Course Management System built using Core Java. It enables administrators to manage students, courses, and enrollments through a structured, menu-driven interface.

The application demonstrates key programming concepts such as Object-Oriented Programming (OOP), collections, exception handling, and modular design. Data is stored in memory using ArrayLists, making it simple, efficient, and ideal for learning purposes.

---

## Features

### Student Management

* Add new students
* View all students
* Search student by ID
* Deactivate student
* Reactivate student

### Course Management

* Add new courses
* View all courses

### Enrollment Management

* Enroll students in courses
* View enrollments by student
* Update enrollment status (ACTIVE, COMPLETED, CANCELLED)

---

## Project Structure

```text id="structure2"
com.airtribe.learntrack
│
├── entity        # Data classes (Student, Course, Enrollment, Person)
├── service       # Business logic layer
├── ui            # Console interface (Main.java)
├── util          # Utility classes (IdGenerator)
├── exception     # Custom exceptions (EntityNotFoundException)
```

---

## Concepts Used

* Classes and Objects
* Constructors and Method Overloading
* Inheritance (Person → Student)
* Encapsulation (private fields with getters/setters)
* Static variables and methods
* Collections (ArrayList)
* Exception Handling (try-catch, custom exceptions)
* Menu-driven application design

---

## Technologies Used

* Java (JDK 8 or above)
* IntelliJ IDEA or any Java IDE

---

## How to Compile and Run

### Using IntelliJ IDEA

1. Open the project folder
2. Navigate to `Main.java`
3. Click the Run button

### Using Terminal

```bash id="compile2"
javac -d out src/com/airtribe/learntrack/ui/Main.java
java -cp out com.airtribe.learntrack.ui.Main
```

---

## Sample Menu

```text id="menu2"
===== LearnTrack Menu =====
1.  Add Student
2.  View Students
3.  Search Student by ID
4.  Deactivate Student
5.  Activate Student
6.  Add Course
7.  View Courses
8.  Enroll Student
9.  View Enrollments by Student
10. Update Enrollment Status
11. Exit
```

---

## Error Handling

* Handles invalid menu input
* Handles non-existent student/course/enrollment IDs
* Uses custom exception: `EntityNotFoundException`

---

## Design Notes

* **ArrayList vs Array**: ArrayList is used because it supports dynamic resizing and simplifies data handling.
* **Static Members**: `IdGenerator` generates unique IDs using static counters.
* **Separation of Concerns**:

  * Entity → data representation
  * Service → business logic
  * UI → user interaction
* **Inheritance**: `Student` extends `Person` to reuse common attributes.

---

## Future Improvements

* Prevent enrollment of inactive students
* Use Enum for enrollment status
* Add course activation/deactivation
* Add file or database storage
* Improve console UI formatting

---
## Class Diagram


                   ┌──────────────────┐
                   │      Person      │
                   ├──────────────────┤
                   │ - id             │
                   │ - firstName      │
                   │ - lastName       │
                   │ - email          │
                   └──────────────────┘
                            ▲
                            │  (Generalization / Inheritance)
                            │
                   ┌──────────────────┐
                   │     Student      │
                   ├──────────────────┤
                   │ - batch          │
                   │ - active         │
                   └──────────────────┘


┌──────────────────┐         1        ┌──────────────────────┐        1         ┌──────────────────┐
│     Student      │◄───────────────►│     Enrollment        │◄───────────────►│      Course       │
└──────────────────┘   (association) ├──────────────────────┤   (association)  └──────────────────┘
                                    │ - id                 │
                                    │ - studentId          │
                                    │ - courseId           │
                                    │ - enrollmentDate     │
                                    │ - status             │
                                    └──────────────────────┘
                                          ▲
                                          │
                                          │ uses
                                          │
                               ┌────────────────────────┐
                               │   EnrollmentService    │
                               └────────────────────────┘


        ┌────────────────────┐
        │  StudentService    │
        └────────────────────┘
                 ▲
                 │ uses
                 │
           ┌──────────────┐
           │   Student    │
           └──────────────┘


        ┌────────────────────┐
        │  CourseService     │
        └────────────────────┘
                 ▲
                 │ uses
                 │
           ┌──────────────┐
           │   Course     │
           └──────────────┘


┌────────────────────────┐
│     IdGenerator        │
├────────────────────────┤
│  (Utility - Static)    │
└────────────────────────┘
          ▲
          │ used by
          │
 ┌──────────────┬──────────────┬──────────────┐
 │   Student    │    Course    │  Enrollment  │
 └──────────────┴──────────────┴──────────────┘


┌──────────────────────────────┐
│ EntityNotFoundException      │
├──────────────────────────────┤
│ <<extends Exception>>        │
└──────────────────────────────┘


┌──────────────────────────────┐
│           Main               │
├──────────────────────────────┤
│ (UI Layer - Console)         │
└──────────────────────────────┘
        │
        │ uses
        ▼
┌────────────────────────────────────────────┐
│ StudentService | CourseService | EnrollmentService │
└────────────────────────────────────────────┘
## Author

Developed as part of Core Java learning to practice OOP, collections, and structured system design.

---
