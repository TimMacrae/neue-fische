package com.oop;

public class Counter {
    static int totalCounter = 0;
    private int instanceCounter = 0;





    static public void incrementTotalCounter() {
        totalCounter++;
    }

    public void incrementInstanceCount() {
        instanceCounter++;
    }

    @Override
    public String toString() {
        return "Counter{" +
                "instanceCounter=" + instanceCounter + "totalCounter=" + totalCounter +
                '}';
    }
}
