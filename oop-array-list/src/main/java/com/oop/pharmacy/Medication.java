package com.oop.pharmacy;

public class Medication {
    private final String name;
    private final int price;
    private final boolean isAvailable;

    public Medication(String name, int price, boolean isAvailable) {
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
