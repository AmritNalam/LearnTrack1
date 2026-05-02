package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.entity.*;
import com.airtribe.learntrack.service.*;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentService ss = new StudentService();
        CourseService cs = new CourseService();
        EnrollmentService es = new EnrollmentService();

        while (true) {
            System.out.println("\n===== LearnTrack Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Deactivate Student");
            System.out.println("5. Activate Student");
            System.out.println("6. Add Course");
            System.out.println("7. View Courses");
            System.out.println("8. Enroll Student");
            System.out.println("9. View Enrollments by Student");
            System.out.println("10. Update Enrollment Status");
            System.out.println("11. Exit");

            int ch;

            try {
                ch = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input!");
                continue;
            }

            try {
                switch (ch) {

                    // 1. Add Student
                    case 1:
                        System.out.print("Enter First Name: ");
                        String fn = sc.nextLine();

                        System.out.print("Enter Last Name: ");
                        String ln = sc.nextLine();

                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();

                        System.out.print("Enter Batch: ");
                        String batch = sc.nextLine();

                        Student s = new Student(
                                IdGenerator.nextStudentId(),
                                fn, ln, email, batch
                        );

                        ss.addStudent(s);
                        System.out.println("Student added successfully!");
                        break;

                    // 2. View Students
                    case 2:
                        if (ss.getAllStudents().isEmpty()) {
                            System.out.println("No students found.");
                        } else {
                            for (Student st : ss.getAllStudents()) {
                                System.out.println(st);
                            }
                        }
                        break;

                    // 3. Search Student
                    case 3:
                        System.out.print("Enter Student ID: ");
                        int sid = Integer.parseInt(sc.nextLine());

                        System.out.println(ss.findStudentById(sid));
                        break;

                    // 4. Deactivate Student
                    case 4:
                        System.out.print("Enter Student ID: ");
                        int did = Integer.parseInt(sc.nextLine());

                        ss.deactivateStudent(did);
                        System.out.println("Student deactivated!");
                        break;

                    // 5. Reactive Student
                    case 5:
                        System.out.print("Enter Student ID: ");
                        int aid = Integer.parseInt(sc.nextLine());

                        ss.activateStudent(aid);
                        System.out.println(" Student activated!");
                        break;

                    // 6. Add Course
                    case 6:
                        System.out.print("Enter Course Name: ");
                        String cname = sc.nextLine();

                        System.out.print("Enter Description: ");
                        String desc = sc.nextLine();

                        System.out.print("Enter Duration (weeks): ");
                        int dur = Integer.parseInt(sc.nextLine());

                        Course c = new Course(
                                IdGenerator.nextCourseId(),
                                cname, desc, dur
                        );

                        cs.addCourse(c);
                        System.out.println("Course added!");
                        break;

                    // 7. View Courses
                    case 7:
                        if (cs.getAllCourses().isEmpty()) {
                            System.out.println("No courses available.");
                        } else {
                            for (Course co : cs.getAllCourses()) {
                                System.out.println(co);
                            }
                        }
                        break;

                    // 8. Enroll Student
                    case 8:
                        System.out.print("Enter Student ID: ");
                        int esid = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Course ID: ");
                        int ecid = Integer.parseInt(sc.nextLine());

                        Enrollment e = new Enrollment(
                                IdGenerator.nextEnrollmentId(),
                                esid, ecid
                        );

                        es.enroll(e);
                        System.out.println("Enrollment successful!");
                        break;

                    // 8. View Enrollments by Student
                    case 9:
                        System.out.print("Enter Student ID: ");
                        int vsid = Integer.parseInt(sc.nextLine());

                        if (es.getByStudent(vsid).isEmpty()) {
                            System.out.println("No enrollments found.");
                        } else {
                            for (Enrollment en : es.getByStudent(vsid)) {
                                System.out.println(en);
                            }
                        }
                        break;

                    // 9. Update Enrollment Status
                    case 10:
                        System.out.print("Enter Enrollment ID: ");
                        int eid = Integer.parseInt(sc.nextLine());

                        Enrollment en = es.findById(eid);

                        System.out.print("Enter new status (ACTIVE/COMPLETED/CANCELLED): ");
                        String status = sc.nextLine();

                        en.setStatus(status);
                        System.out.println("Status updated!");
                        break;

                    // 10. Exit
                    case 11:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid option!");
                }

            } catch (EntityNotFoundException ex) {
                System.out.println("❌ " + ex.getMessage());
            } catch (Exception ex) {
                System.out.println("❌ Invalid input!");
            }
        }
    }
}