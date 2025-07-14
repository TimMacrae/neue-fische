package com.ecosystem;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
public class Student {
    private String firstName;
    private String lastName;
    private UUID id;
    private String address;
    private double grade;
}
