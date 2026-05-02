package com.airtribe.learntrack.entity;

public class Student extends Person {
    private String batch;
    private boolean active;

    public Student(int id, String firstName, String lastName, String email, String batch) {
        super(id, firstName, lastName, email);
        this.batch = batch;
        this.active = true;
    }

    public void deactivate() { this.active = false; }

    public void activate() {
        this.active = true;
    }

    public boolean isActive() {
        return active;
    }
    public String toString() {
        return id + " | " + getDisplayName() + " | Batch: " + batch + " | Active: " + active;
    }
}
