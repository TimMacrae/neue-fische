package com.ecosystem;

import java.util.*;
import java.util.stream.Collectors;

public class PersonRepo {
    Map<UUID, Person> persons;

    public PersonRepo(Map<UUID, Person> persons) {
        this.persons = persons;
    }

    public Map<Gender, Long> countGenders() {
        return persons.values().stream()
                .collect(Collectors.groupingBy(
                        Person::getGender,
                        Collectors.counting()
                ));
    }

    public List<Person> getAllPersonsWithTheFavoriteDay(DaysOfWeek favoriteDay) {
       return persons.values().stream().filter(person -> person.favoriteDay().equals(favoriteDay)).toList();
    }

    public Optional<Person> getPersonById(UUID id) {
        return Optional.ofNullable(persons.get(id));
    }

    public Optional<Person> getPersonByName(String name) {
        return (persons.values().stream().filter(person -> person.name().equals(name)).findFirst());
    }

}
