package com.ecosystem;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
@AllArgsConstructor
public class Course {
    UUID id;
    String name;
    Teacher teacher;
    List<Student> students;
}
