package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import java.util.ArrayList;

public class EnrollmentService {
    private ArrayList<Enrollment> enrollments = new ArrayList<>();

    public void enroll(Enrollment e) { enrollments.add(e); }

    public ArrayList<Enrollment> getByStudent(int sid) {
        ArrayList<Enrollment> res = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getStudentId() == sid) res.add(e);
        }
        return res;
    }

    public Enrollment findById(int id) throws EntityNotFoundException {
        for (Enrollment e : enrollments) {
            if (e.getId() == id) return e;
        }
        throw new EntityNotFoundException("Enrollment not found");
    }
}
