package com.ecosystem.springdatamongo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CharacterDto {
    private String name;
    private int age;
    private String profession;
}
