package com.oopbonus;

public class Car extends Vehicle{
    public Car(String id, String name) {
        super(id, name);
    }

    @Override
    public void accelerate(int kmh) {
        this.velocity += kmh;
        System.out.println(name + " accelerated by " + kmh + " km/h. New speed: " + velocity + " km/h.");
    }
}
