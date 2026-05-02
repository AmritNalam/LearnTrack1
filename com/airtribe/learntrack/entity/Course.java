package com.airtribe.learntrack.entity;

public class Course {
    private int id;
    private String courseName;
    private String description;
    private int durationInWeeks;

    public Course(int id, String courseName, String description, int durationInWeeks) {
        this.id = id;
        this.courseName = courseName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
    }

    public int getId() { return id; }

    public String toString() {
        return id + " | " + courseName + " | Duration: " + durationInWeeks;
    }
}
