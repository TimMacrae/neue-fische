package com.ecosystem;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {
    private String firstName;
    private String lastName;
    private String id;
    private String address;
    private String grade;
}
