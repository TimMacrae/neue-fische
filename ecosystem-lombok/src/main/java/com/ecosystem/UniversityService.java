package com.ecosystem;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class UniversityService {
    private University  university;


    Course addCourse (Course course) {
        university.courses().add(course);
        return course;
    }

    Student addStudent(Student student) {
        university.students().add(student);
        return student;
    }

    Teacher addTeacher(Teacher teacher) {
        university.teachers().add(teacher);
        return teacher;
    }

    public double calculateAverageGradeForCourse(Course course) {
        return course.getStudents().stream()
                .mapToDouble(Student::getGrade)
                .average()
                .orElse(0.0);
    }

    public double calculateAverageGradeForUniversity(University university) {
        return university.courses().stream()
                .flatMap(course -> course.getStudents().stream())
                .mapToDouble(Student::getGrade)
                .average()
                .orElse(0.0);
    }

    public List<Student> getStudentsWithMinimumGrade(University university, double minGrade) {
        return university.courses().stream()
                .flatMap(course -> course.getStudents().stream())
                .filter(student -> student.getGrade() <= minGrade)
                .collect(Collectors.toList());
    }




}
