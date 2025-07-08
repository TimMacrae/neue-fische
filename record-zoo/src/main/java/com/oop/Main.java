package com.oop;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        Species primeApe = new Species("primeApe", "everything", 2000);
        Species macropodidae = new Species("macropodidae", "gras", 4000);

        Owner zooHamburg = new Owner("Zoo Hamburg", 38, "Germany");
        Owner wildLifePark = new Owner("Wildlife Park", 25, "Australia");

        Animal monkey = new Animal("1", "DonkiKong", primeApe, 14, zooHamburg);
        Animal kangaroo = new Animal("2", "Elli", macropodidae, 8, wildLifePark);
        Animal wallaby = new Animal("3", "Wally", macropodidae, 12, wildLifePark);

        System.out.println(monkey.toString() + " | " + monkey.name() + " | " + monkey.Species() + " | " + monkey.age());
        System.out.println(kangaroo.toString());
        System.out.println(wallaby.toString());

        // Bonus
        Zoo zoo = new Zoo(List.of(monkey,kangaroo), 0).calculateTotalFood();
        System.out.println("Zoo: " + zoo.toString());

        // Bonus
        var newZooAnimal =  zoo.addAnimal(wallaby).calculateTotalFood();
        System.out.println("Zoo: " + newZooAnimal.toString());
    }
}