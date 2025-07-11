package com.ecosystem;

import java.util.UUID;

public record Person(UUID id , String name, DaysOfWeek favoriteDay, Gender gender) {


    public Gender getGender() {
        return gender;
    }
}
