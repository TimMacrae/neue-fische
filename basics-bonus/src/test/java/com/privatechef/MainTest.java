package com.privatechef;

import org.junit.jupiter.api.Test;

import static com.privatechef.Main.checkIfNumberIsBiggerThan0;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void checkIfNumberIsBiggerThan0_shouldReturnTrue() {
        assertTrue(Main.checkIfNumberIsBiggerThan0(5));
        assertFalse(Main.checkIfNumberIsBiggerThan0(0));
    }

    @Test
    void calculateQuadratFromANumber_shouldReturnTheCorrectNumber() {
        assertEquals(25, Main.calculateQuadratFromANumber(5));
        assertEquals(16, Main.calculateQuadratFromANumber(4));
    }

    @Test
    void generateHelloMessage_shouldReturnHelloMessage() {
        assertEquals("Hello, Tim!", Main.generateHelloMessage("Tim"));
        assertEquals("Hello unknown", Main.generateHelloMessage(""));
    }
}