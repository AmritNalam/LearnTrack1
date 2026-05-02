package com.airtribe.learntrack.entity;

import java.time.LocalDate;

public class Enrollment {
    private int id;
    private int studentId;
    private int courseId;
    private LocalDate date;
    private String status;

    public Enrollment(int id, int sid, int cid) {
        this.id = id;
        this.studentId = sid;
        this.courseId = cid;
        this.date = LocalDate.now();
        this.status = "ACTIVE";
    }

    public int getId() { return id; }
    public int getStudentId() { return studentId; }

    public void setStatus(String status) { this.status = status; }

    public String toString() {
        return id + " | Student: " + studentId + " | Course: " + courseId + " | Status: " + status;
    }
}
