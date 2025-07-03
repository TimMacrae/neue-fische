package com.oop;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("Mercedes", "S3", "1986");
        Car car = new Car("BMW", "5", "2025","4");
        Motorcycle motorcycle = new Motorcycle("Ninja" , "M1" , "2020" , "Sportbike" , "350");
        Ships ship = new Ships(new Vehicle("Ship deluxe", "Mega ship", "2025"), "With 2 Jet skies");

        vehicle.information();
        car.information();
        motorcycle.information();
        ship.information();
    }
}