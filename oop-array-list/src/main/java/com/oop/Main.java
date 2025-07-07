package com.oop;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        School school = new School();

        Student newStudentOne = new Student("Tim", "Macrae",1 );
        Student newStudentTwo = new Student("Georgia", "Macrae",2 );
        Student newStudentThree = new Student("John", "Doe",3 );

        newStudentOne.addCourse(new Course("Math", "Math Teacher","CR:1"));
        newStudentTwo.addCourse(new Course("Tech", "Tech Teacher","CR:2"));
        newStudentTwo.addCourse(new Course("Math Expert", "Math Teacher expert","CR:3"));
        newStudentThree.addCourse(new Course("English", "English Teacher","CR:4"));


        school.addStudent(newStudentOne);
        school.addStudent(newStudentTwo);
        school.addStudent(newStudentThree);


       System.out.println(School.getStudents());
       System.out.println("Find Student: " + School.getStudentById(2));
       System.out.println("Student Courses: " + School.getCoursesFromStudentId(3));



    }
}