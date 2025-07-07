package com.oopbonus;

public class Bicycle extends Vehicle {

    public Bicycle(String id, String name) {
        super(id, name);
    }

    @Override
    public int accelerate(int kmh) {
        if((velocity += kmh) > 35) {
            System.out.println("kmh is over 35, this is not allowed");
            return velocity;
        }
        System.out.println(name + " accelerated by " + kmh + " km/h. New speed: " + velocity + " km/h.");
        velocity += kmh;
        return velocity;
    }

}
