package com.oopbonus;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Car car = new Car("CAR001", "Mercedes S");
        car.accelerate(50);
        car.accelerate(100);

        Bicycle bicycle = new Bicycle("BIC001", "MountS3");
        bicycle.accelerate(20);
        bicycle.brake();
        bicycle.accelerate(30);

        Bicycle newBicycle = new Bicycle("BIC002", "MountS4");
        Bicycle newCar = new Bicycle("BIC003", "S5");

        Scanner sc = new Scanner(System.in);
        System.out.println("Bike or Car");
        String bikeOrCar = sc.nextLine();

        if(bikeOrCar.equals("Bike")) {
        Scanner scBike = new Scanner(System.in);
            System.out.println("Accelerate or Brake");
            String accelerateOrBrake = scBike.nextLine();
            if(accelerateOrBrake.equals("Brake")) newBicycle.brake();
            if(accelerateOrBrake.equals("Accelerate")) newBicycle.accelerate(20);
        }

        if(bikeOrCar.equals("Car")) {
            Scanner scCar = new Scanner(System.in);
            System.out.println("Accelerate or Brake");
            String accelerateOrBrake = scCar.nextLine();
            if(accelerateOrBrake.equals("Brake")) newCar.brake();
            if(accelerateOrBrake.equals("Accelerate")) newCar.accelerate(20);
        }

    }
}