package com.oopbonus;

public class Bicycle extends Vehicle {

    public Bicycle(String id, String name) {
        super(id, name);
    }

    @Override
    public void accelerate(int kmh) {
        if((this.velocity += kmh) > 35) {
            System.out.println("kmh is over 35, this is not allowed");
            return;
        }
        System.out.println(name + " accelerated by " + kmh + " km/h. New speed: " + velocity + " km/h.");
        this.velocity += kmh;
    }

}
