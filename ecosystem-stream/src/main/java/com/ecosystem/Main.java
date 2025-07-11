package com.ecosystem;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> numbers = List.of(10, 20, 30, 2,3,5,7,6);
        List<Integer> oddNumber = numbers.stream()
                .filter(number -> number % 2 == 0).toList();
        List<Integer> evenNumber = numbers.stream()
                .filter(number -> number % 2 == 1).toList();
        List<Integer> doubleNumbers = numbers.stream()
                .map(number -> number + number).toList();
        String reduceNumbersToOne = numbers.stream()
                .reduce(0, Integer::sum).toString();

        // numbers.forEach(System.out::println);
        System.out.println(oddNumber);
        System.out.println(evenNumber);
        System.out.println(doubleNumbers);
        System.out.println(reduceNumbersToOne);

        // Bonus
        StudentsRepo studentsRepo = new StudentsRepo();
        try (var studentFile = Files.lines(Path.of("students.csv"), StandardCharsets.UTF_8)) {
            studentsRepo.importStudentsFromFile(studentFile);
        }
        System.out.println(studentsRepo.getStudents());
        System.out.println(studentsRepo.getStudent("2").orElseThrow(()->new NoSuchElementException("No student found")));
        System.out.println(studentsRepo.getStudent("40").orElseThrow(()->new NoSuchElementException("No student found")));

    }
}