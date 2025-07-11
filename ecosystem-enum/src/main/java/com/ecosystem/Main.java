package com.ecosystem;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;


public class Main {
    public static void main(String[] args) {
        String monday = DaysOfWeek.MONDAY.getDayOfWeek();
        System.out.println(monday);
        System.out.println(DaysOfWeek.SATURDAY.getDayOfWeek());

        Person person1 = new Person(UUID.randomUUID(), "Tim", DaysOfWeek.SUNDAY, Gender.MEN);
        Person person2 = new Person(UUID.randomUUID(), "Alex", DaysOfWeek.MONDAY, Gender.DIVERS);
        Person person3 = new Person(UUID.randomUUID(), "Ash", DaysOfWeek.FRIDAY, Gender.WOMEN);
        Person person4 = new Person(UUID.randomUUID(), "Georgia", DaysOfWeek.SATURDAY, Gender.WOMEN);

        PersonRepo personRepo = new PersonRepo(new HashMap<>() {{
            put(person1.id(), person1);
            put(person2.id(), person2);
            put(person3.id(), person3);
            put(person4.id(), person4);
        }});

        System.out.println(personRepo.countGenders());
        System.out.println(personRepo.getAllPersonsWithTheFavoriteDay(DaysOfWeek.SATURDAY));

        Optional<Person>optPerson = personRepo.getPersonById(UUID.randomUUID());
        if (optPerson.isPresent()) {
            System.out.println(optPerson.get().name());
            System.out.println(optPerson.get().gender());
        }

        Optional<Person>optPersonName = personRepo.getPersonByName("Tim");
        optPersonName.ifPresent(person -> System.out.println(person.name()));

        Person optPersonName2 = personRepo.getPersonByName("Alex").orElseThrow(()-> new IllegalArgumentException("Name not found"));
        System.out.println(optPersonName2.name());



    }
}