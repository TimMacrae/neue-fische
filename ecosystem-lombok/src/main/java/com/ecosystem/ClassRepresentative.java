package com.ecosystem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

import java.util.UUID;

@Builder
@ToString
public class ClassRepresentative {
    UUID id;
    String name;
    String classId;
}
