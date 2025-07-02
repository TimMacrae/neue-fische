package com.oopbonus;

public class CarInspectionService {

    public boolean hasFourTires (Car car) {
        int tires = car.getNumberOfTires();
        return  tires == 4;
    }

    public boolean hasSeatbelt (Car car) {
        return car.isSeatBelt();
    }

    public boolean hasAirBag (Car car) {
        return car.isAirBag();
    }

    public boolean hasThreeOrFiveDoors (Car car) {
        int doors = car.getNumberOfDoors();
        return doors == 3 || doors == 5;
    }

    public boolean checkCar (Car car) {
        return hasThreeOrFiveDoors(car)  && hasSeatbelt(car) && hasFourTires(car) && hasAirBag(car);
    }
}
