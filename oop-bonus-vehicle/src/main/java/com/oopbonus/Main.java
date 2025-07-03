package com.oopbonus;

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
    }
}