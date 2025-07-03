package com.oop;

public class Car extends Vehicle {
    private final String doors;

    public Car(String manufacturer, String model, String yearOfManufacture, String doors) {
        super(manufacturer, model, yearOfManufacture);
        this.doors = doors;
    }

    @Override
    public void information(){
        System.out.println("Information with doors: " + this.getManufacturer() + " " + this.getModel() + " " + this.getYearOfManufacture() + " " + doors);
    }
}
