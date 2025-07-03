package com.oop;

public class Vehicle {
    private String manufacturer;
    private String model;
    private String yearOfManufacture;

    public Vehicle(String manufacturer, String model, String yearOfManufacture) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
    }

    public void information(){
        System.out.println("Information: " + manufacturer + " " + model + " " + yearOfManufacture);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }
}
