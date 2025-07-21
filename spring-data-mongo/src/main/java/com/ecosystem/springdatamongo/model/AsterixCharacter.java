package com.ecosystem.springdatamongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("characters")
@AllArgsConstructor
public class AsterixCharacter {
    private String id;
    private String name;
    private int age;
    private String profession;
}
