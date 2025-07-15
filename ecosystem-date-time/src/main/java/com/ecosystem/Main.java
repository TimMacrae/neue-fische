package com.ecosystem;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        // Instant = Zulu time
        Instant instant = Instant.now();
        System.out.println(instant);

        // Flugzeugabflug mit Zeitzone
        ZonedDateTime departure = ZonedDateTime.of(2025, 7, 10, 15, 30, 0, 0, ZoneId.of("Europe/Berlin"));

        // Nur Uhrzeit im Fahrplan
        LocalTime busTime = LocalTime.of(8, 15);

        // Notruf-Zeitpunkt
        Instant emergencyReceived = Instant.now();

        // Datum von Ostern
        LocalDate easter = LocalDate.of(2022, 4, 17);

        // Dauer von einem Tag
        Duration oneDay = Duration.ofDays(1);

        // Datum neben Unterschrift
        LocalDate signedOn = LocalDate.now();

        // Silvester unabhängig vom Ort
        MonthDay newYear = MonthDay.of(1, 1);
        LocalTime midnight = LocalTime.MIDNIGHT;

        // Videoanruf mit Zeitzone
        ZonedDateTime callTime = ZonedDateTime.of(2025, 7, 10, 18, 0, 0, 0, ZoneId.of("America/New_York"));

        // Instant to LocalDateTime
        ZoneId zoneId = ZoneId.of("Australia/Melbourne");
        Instant instantNow = Instant.now();
        LocalTime localDateTime = LocalTime.ofInstant(instantNow, zoneId);
        System.out.println("Instant to LocalDateTime: " + localDateTime);

        // Format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd/MM/yyyy : HH:mm:ss");
        String formattedDate = LocalDateTime.now().format(formatter);
        System.out.println("Formatted date: " + formattedDate);

        // String in LocalDateTime
        String time =  "12/08/2024 : 11:11:11";
        LocalDateTime stringToLocalDateTime = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("dd/MM/yyyy : HH:mm:ss"));
        System.out.println("LocalDateTime to String: " + stringToLocalDateTime);

        //  Difference in x
        LocalDateTime start = LocalDateTime.of(2025, 7, 10, 15, 30);
        LocalDateTime end = LocalDateTime.now();

        long diffHours = ChronoUnit.HOURS.between(start, end);
        long diffMinutes = ChronoUnit.MINUTES.between(start, end);
        long diffSeconds = ChronoUnit.SECONDS.between(start, end);
        long diffDays = ChronoUnit.DAYS.between(start, end);
        long diffMonths = ChronoUnit.MONTHS.between(start, end);
        long diffYears = ChronoUnit.YEARS.between(start, end);
        long diffWeeks = ChronoUnit.WEEKS.between(start, end);

        System.out.println("diffHours: " + diffHours);
        System.out.println("diffMinutes: " + diffMinutes);
        System.out.println("diffSeconds: " + diffSeconds);
        System.out.println("diffDays: " + diffDays);
        System.out.println("diffMonths: " + diffMonths);
        System.out.println("diffYears: " + diffYears);
        System.out.println("diffWeeks: " + diffWeeks);

    }
}