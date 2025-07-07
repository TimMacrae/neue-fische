package com.oop.pharmacy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicationTest {

    @Test
    void createMedication_whenCreated(){
        Medication medi = new Medication("Panadol", 50, true);

        assertEquals("Panadol", medi.getName());
        assertEquals(50, medi.getPrice());
        assertTrue(medi.isAvailable());
    }

    @Test
    void getName() {
        Medication med = new Medication("Panadol", 50, true);
        assertEquals("Panadol", med.getName());
    }
}