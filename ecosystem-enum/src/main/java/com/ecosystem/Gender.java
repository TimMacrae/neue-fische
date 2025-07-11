package com.ecosystem;

public enum Gender {
    MEN("Men"),
    WOMEN("Woman"),
    DIVERS("Divers");

        private final String gender;
    Gender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return gender;
    }
}
