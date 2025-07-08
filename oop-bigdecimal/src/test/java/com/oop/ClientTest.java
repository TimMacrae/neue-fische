package com.oop;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void createClientWith_shouldHaveAllFields() {
        String id = UUID.randomUUID().toString();
        String firstName = "John";
        String lastName = "Doe";
        Client client = new Client(id,firstName,lastName);

        assertEquals(id, client.customerId());
        assertEquals(firstName, client.firstName());
        assertEquals(lastName, client.lastName());
    }
}