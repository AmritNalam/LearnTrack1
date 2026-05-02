package com.airtribe.learntrack.util;

public class IdGenerator {
    private static int sid = 1, cid = 1, eid = 1;

    public static int nextStudentId() { return sid++; }
    public static int nextCourseId() { return cid++; }
    public static int nextEnrollmentId() { return eid++; }
}
