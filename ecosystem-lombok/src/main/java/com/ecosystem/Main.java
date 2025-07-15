package com.ecosystem;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        University university = University.builder()
                .id(UUID.randomUUID())
                .name("Hamburg University")
                .courses(new ArrayList<>())
                .teachers(new ArrayList<>())
                .students(new ArrayList<>())
                .build();
        UniversityService universityService = new UniversityService(university);

        Student studentTim = universityService.addStudent(new Student("Tim", "Macrae", UUID.randomUUID(), "Street2", 1.2));
        Student studentAlex = universityService.addStudent(new Student("Alex", "Doe", UUID.randomUUID(), "Street2", 3.4));
        Student studentBobby = universityService.addStudent(new Student("Bobby", "Doe", UUID.randomUUID(), "Street2", 2.3));
        Student studentAlfi = universityService.addStudent(new Student("Alfi", "Smith", UUID.randomUUID(), "Street2", 1.1));
        Student studentBob = universityService.addStudent(new Student("Bob", "Smith", UUID.randomUUID(), "Street2", 4.0));

        Teacher teacherJane = universityService.addTeacher(Teacher.builder().id(UUID.randomUUID()).name("Jane Doe").subject("Math").build());
        Teacher dominic = universityService.addTeacher(Teacher.builder().id(UUID.randomUUID()).name("Dominic").subject("Programming").build());

        Course courseMath = universityService.addCourse(new Course(UUID.randomUUID(), "Math beginner", teacherJane, List.of(studentAlex, studentAlfi)));
        Course courseDeveloper = universityService.addCourse(new Course(UUID.randomUUID(), "Fullstack dev", dominic, List.of(studentTim, studentBobby, studentBob)));

        System.out.println("Course math:" + courseMath.toString());
        System.out.println("Course developer:" + courseDeveloper.toString());
        System.out.println("Average course grade: " + universityService.calculateAverageGradeForCourse(courseMath));
        System.out.println("Average University course grade: " + universityService.calculateAverageGradeForUniversity(university));
        System.out.println("All Students over 2.0: " + universityService.getStudentsWithMinimumGrade(university, 2.0));


        // œWith
        Teacher codingTeacher = Teacher.builder()
                .id(UUID.randomUUID())
                .name("Alex Doe")
                .build();
        codingTeacher = codingTeacher.withSubject("coding");

        // @Builder
        ClassRepresentative classRepresentative = ClassRepresentative.builder()
                .name("Alex Doe")
                .id(UUID.randomUUID())
                .classId("1B")
                .build();

    }
}