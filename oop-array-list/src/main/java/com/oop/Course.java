package com.oop;

public class Course {
    private final String courseName;
    private final String lecturer;
    private final String room;

    public Course(String courseName, String lecturer, String room) {
        this.courseName = courseName;
        this.lecturer = lecturer;
        this.room = room;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", lecturer='" + lecturer + '\'' +
                ", room='" + room + '\'' +
                '}';
    }
}
