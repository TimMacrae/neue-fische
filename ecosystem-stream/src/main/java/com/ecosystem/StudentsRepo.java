package com.ecosystem;

import java.util.*;
import java.util.stream.Stream;

public class StudentsRepo {
    Set< Student> students = new HashSet<>();

    public void addStudent(Student student){
        students.add(student);
    }

    public Optional<Student> getStudent(String id){
        return students.stream().filter(s->s.id().equals(id)).findFirst();
    }

    public Set<Student> getStudents(){
        return students;
    }

    public void importStudentsFromFile(Stream<String> studentFile){
        studentFile
                .filter(line -> !line.equals("ID, Name, postalCode, age"))
                .filter(line -> !line.isEmpty())
                .map(line -> Arrays.stream(line.split(","))
                        .map(String::trim)
                        .toArray(String[]::new))
                .map(e -> new Student(e[0], e[1], Integer.parseInt(e[2]), Integer.parseInt(e[3])))
                .toList().forEach(this::addStudent);
    }



}
