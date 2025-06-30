package com.privatechef;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static boolean isEven(int number){
        return number % 2 == 0;
    }

    public static int multiply(int a , int b){
        return a * b;
    }

    public  static String stringToUppercase(String text){
        return text.toUpperCase();
    }

    public static boolean isPositive(int num){
        return num > 0;
    }

    public static String fizzBuzz(int num){
        if(num % 3 == 0 && num % 5 == 0)return "FizzBuzz";
        if(num % 5 == 0) return "Buzz";
        if(num % 3 == 0) return "Fizz";
        return "" + num;
    }

}