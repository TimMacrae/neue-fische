package com.oop;

import java.util.ArrayList;
import java.util.List;

public class School {
    private static final List<Student> students = new ArrayList<>();


    public List<Student> addStudent (Student student) {
        students.add(student);
        return students;
    };

    public List<Student> removeStudent (Student student) {
        students.remove(student);
        return students;
    }

    public static List<Student> getStudents() {
        return students;
    }

    public static Student getStudentById (int id) {
       Student surrentStudent =  students.stream().filter(student -> student.getStudentId() == id).findFirst().orElse(null);
       if (surrentStudent == null) {
           System.out.println("No student with id " + id + " found");
       }
       return surrentStudent;
    }

    public static List<Course> getCoursesFromStudentId(int id) {
        Student student = getStudentById(id);
        return student.getCourses();
    }

    @Override
    public String toString() {
        return "School Students:" + students;
    }


}
