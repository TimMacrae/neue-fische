package com.ecosystem;

import java.util.List;
import java.util.UUID;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student student = new Student("Tim", "Macrae", null, "Street2", null);
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        System.out.println(student.getAddress());

        System.out.println(student.toString());

        Teacher teacher = new Teacher(UUID.randomUUID(), "Alex Doe", "Math");
        System.out.println(teacher.toString());

        Course mathCourse = new Course();
        mathCourse.setId(UUID.randomUUID());
        mathCourse.setName("Math");
        mathCourse.setTeacher(teacher);
        mathCourse.setStudents(List.of(student));
        System.out.println(mathCourse.toString());

    }
}