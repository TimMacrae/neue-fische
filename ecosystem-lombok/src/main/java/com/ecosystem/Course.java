package com.ecosystem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private UUID id;
    private String name;
    private Teacher teacher;
    private List<Student> students;
}
