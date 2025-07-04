package com.oop;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Counter counter2 = new Counter();
        Counter counter3 = new Counter();

        counter.incrementInstanceCount();
        counter2.incrementInstanceCount();
        counter3.incrementInstanceCount();

        Counter.incrementTotalCounter();
        Counter.incrementTotalCounter();
        Counter.incrementTotalCounter();

        System.out.println("counter" + counter.toString());
         System.out.println("Calculator add: " + Calculator.add(5,5));
         System.out.println("Calculator subtract: " + Calculator.subtract(5,5));
         System.out.println("Calculator multiply: " + Calculator.multiply(5,5));
         System.out.println("Calculator divide: " + Calculator.divide(5,5));
    }
}