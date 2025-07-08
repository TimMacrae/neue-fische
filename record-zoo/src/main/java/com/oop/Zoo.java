package com.oop;

import java.util.ArrayList;
import java.util.List;

public record Zoo(List<Animal> animals , int totalFood) {

    Zoo addAnimal(Animal animal) {
        List<Animal> newAnimals = new ArrayList<>(this.animals);
        newAnimals.add(animal);
        return new Zoo(newAnimals, this.totalFood);
    }

    Zoo calculateTotalFood() {
        int newTotalFood = 0;
        for (Animal animal : animals) {
            newTotalFood += animal.Species().requirementInGramsPerDay();
        }

        return new Zoo(this.animals, newTotalFood);
    }

}
