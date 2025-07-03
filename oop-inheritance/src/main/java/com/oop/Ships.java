package com.oop;

public class Ships {
    private final Vehicle vehicle;
    private final String jetSky;

    public Ships(Vehicle vehicle, String jetSky) {
        this.vehicle = vehicle;
        this.jetSky = jetSky;
    }

    public void information() {
        System.out.println("Information about the ship: " + vehicle.getManufacturer() + " " + vehicle.getModel() + " " + vehicle.getYearOfManufacture() + " " + jetSky);
    }
}
