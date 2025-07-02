package com.oopstart;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.startCar();

        Car car2 = new Car();
        car2.setSpeed(10);

        Person personA = new Person("Tim", 38, "Men");
        Person personB = new Person("Alex", 20, "Neutral");
        personA.introduceYourself();
        personB.introduceYourself();
    }
}