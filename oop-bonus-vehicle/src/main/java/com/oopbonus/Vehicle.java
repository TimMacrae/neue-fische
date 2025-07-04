package com.oopbonus;

public abstract class Vehicle implements Accelerateable{
    protected String id;
    protected String name;
    protected int velocity;

    public Vehicle(String id, String name) {
        this.id = id;
        this.name = name;
        this.velocity = 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getVelocity() {
        return velocity;
    }

    @Override
    public void brake() {
        this.velocity = 0;
    }
}
