package com.ecosystem;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class DateTime {
    public static void main(String[] args) {
        LocalDateTime dateTimeNow = LocalDateTime.now();
        System.out.println(dateTimeNow);

        dateTimeNow = dateTimeNow.plusWeeks(2);
        System.out.println(dateTimeNow);

        LocalDateTime dateTimeBetween = LocalDateTime.of(2020, Month.JANUARY, 1, 2, 2, 0);

        // Check if dateTimeNow is before dateTimeBetween
        if (dateTimeNow.isBefore(dateTimeBetween)) {
            System.out.println("dateTimeNow is before dateTimeBetween");
        }

        // Check if dateTimeNow is after dateTimeBetween
        if (dateTimeNow.isAfter(dateTimeBetween)) {
            System.out.println("dateTimeNow is after dateTimeBetween");
        }

        long diffDays = ChronoUnit.DAYS.between(dateTimeNow, dateTimeBetween);
        System.out.println("diffDays: " + diffDays);

        // Bonus
        Animal dog = new Animal("Bello", LocalDate.of(2020, 10, 15));
        LocalDate today = LocalDate.now();

        LocalDate nextBirthday = dog.getBirthday().withYear(today.getYear());

        if (nextBirthday.isBefore(today) || nextBirthday.isEqual(today)) {
            nextBirthday = nextBirthday.plusYears(1);
        }

        long daysUntil = ChronoUnit.DAYS.between(today, nextBirthday);

        System.out.println("Name: " + dog.getName());
        System.out.println("Birthday: " + dog.getBirthday());
        System.out.println("Days until the next birthday: " + daysUntil);


    }
}
