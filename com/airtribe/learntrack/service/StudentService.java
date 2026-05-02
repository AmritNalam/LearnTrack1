package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import java.util.ArrayList;

public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student s) { students.add(s); }

    public ArrayList<Student> getAllStudents() { return students; }

    public Student findStudentById(int id) throws EntityNotFoundException {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        throw new EntityNotFoundException("Student not found");
    }

    public void deactivateStudent(int id) throws EntityNotFoundException {
        Student s = findStudentById(id);

        if (!s.isActive()) {
            System.out.println("Student is already inactive.");
        } else {
            s.deactivate();
        }
    }

    public void activateStudent(int id) throws EntityNotFoundException {
        Student s = findStudentById(id);

        if (s.isActive()) {
            System.out.println("Student is already active.");
        } else {
            s.activate();
        }
    }

}
