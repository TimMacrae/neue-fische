package com.oopstart;

public class Car {
    private String brand;
    private String model;
    private String color;
    private String yearOfManufacture;
    private int speed;

    public Car(String brand, String model, String color, String yearOfManufacture, int speed) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.yearOfManufacture = yearOfManufacture;
        this.speed = speed;
    }

    public Car(){
    }

    public void startCar(){
        System.out.println("Brum Brum");
    }


    public void setSpeed(int speed) {
        this.speed = speed;
        System.out.println("SPEED" + speed);
    }



}
