package com.oop;

public class Motorcycle extends Vehicle {
    private final String type;
    private final String ps;

    public Motorcycle(String manufacturer, String model, String yearOfManufacture, String type, String ps) {
        super(manufacturer, model, yearOfManufacture);
        this.type = type;
        this.ps = ps;
    }

    @Override
    public void information() {
       System.out.println("Information with doors: " + this.getManufacturer() + " " + this.getModel() + " " + this.getYearOfManufacture() + " " + type + " " + this.ps);
    }
}
