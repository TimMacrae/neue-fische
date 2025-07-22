package com.ecosystem.springdatamongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document("characters")
@AllArgsConstructor
public class AsterixCharacter {
    private String id;
    private String name;
    private int age;
    private String profession;
    private LocalDate created;
}
