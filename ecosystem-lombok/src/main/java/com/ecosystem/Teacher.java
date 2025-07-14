package com.ecosystem;

import lombok.Builder;
import lombok.With;

import java.util.UUID;

@Builder
@With
public record Teacher(UUID id, String name, String subject) {
}
