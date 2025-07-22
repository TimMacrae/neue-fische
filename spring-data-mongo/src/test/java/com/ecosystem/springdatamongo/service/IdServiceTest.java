package com.ecosystem.springdatamongo.service;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class IdServiceTest {
    @Test
    void generateId_shouldReturnValidUUIDString() {
        String id = IdService.generateId();
        assertDoesNotThrow(() -> UUID.fromString(id));
    }

    @Test
    void generateId_shouldReturnMockedUUIDString() {
        String fakeId = "123e4567-e89b-12d3-a456-426614174000";
        UUID fakeUuid = UUID.fromString(fakeId);

        try (MockedStatic<UUID> mocked = Mockito.mockStatic(UUID.class)) {
            mocked.when(UUID::randomUUID).thenReturn(fakeUuid);

            String id = IdService.generateId();
            assertEquals(fakeId, id);
        }
    }

}