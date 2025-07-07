package com.oop.pharmacy;

import java.util.HashMap;
import java.util.Map;

public class Pharmacy {
    private static final Map<String, Medication> pharmacies = new HashMap<>();


    public int getCount() {
        return pharmacies.size();
    }

    public void save(Medication medication) {
        pharmacies.put(medication.getName(), medication);
    }

    public Medication find(String medicationName) {
        return pharmacies.get(medicationName);
    }

    public void delete(String medicationName) {
        pharmacies.remove(medicationName);
    }

    public void deleteAll() {
        pharmacies.clear();
    }

    public Map<String, Medication> getPharmacies() {
        for(Map.Entry<String, Medication> entry : pharmacies.entrySet()) {
            System.out.println(entry.toString());
        }
        return pharmacies;
    }
}
