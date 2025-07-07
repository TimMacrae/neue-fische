package com.oop.pharmacy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PharmacyTest {
    Pharmacy pharmacy = new Pharmacy();

   @BeforeEach
   void setUp() {
       pharmacy.deleteAll();
   }


    @Test
    void getCount() {
        assertEquals(0, pharmacy.getCount());
    }

    @Test
    void save() {
        Medication medi = new Medication("Panadol", 50 ,true);
        pharmacy.save(medi);

        assertEquals(1, pharmacy.getCount());
    }

    @Test
    void find() {
        pharmacy.save(new Medication("Panadol", 50 ,true));
        Medication findMedi = pharmacy.find("Panadol");
        assertEquals("Panadol", findMedi.getName());

        Medication findMedi2 = pharmacy.find("Null");
        assertNull(findMedi2);
    }

    @Test
    void delete() {
        pharmacy.save(new Medication("Panadol", 50 ,true));
        assertEquals(1, pharmacy.getCount());

        pharmacy.delete("Panadol");
        assertEquals(0, pharmacy.getCount());
        assertNull(pharmacy.find("Panadol"));

    }

    @Test
    void getPharmacies() {
        Medication medi = new Medication("Panadol", 50 ,true);

        Map<String, Medication> listMock = new HashMap<>();
        listMock.put("Panadol", medi);

        pharmacy.save(medi);

        assertEquals(listMock, pharmacy.getPharmacies());

    }
}