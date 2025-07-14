package com.ecosystem;

import lombok.Builder;
import lombok.With;

import java.util.List;
import java.util.UUID;

@With
@Builder
public record University(UUID id, String name, List<Course> courses, List<Student> students , List<Teacher> teachers) {
}
