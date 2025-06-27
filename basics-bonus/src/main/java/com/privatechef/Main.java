package com.privatechef;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Bonus
        // printName("Tim", 5);
        // sayHello();

    }

    public static void printName(String name, int num){
        for(int j=0;j<num;j++){
            System.out.println(name);
        }
    }

    public static boolean checkIfNumberIsBiggerThan0( int num){
        return num > 0;
    }

    public static int calculateQuadratFromANumber(int num){
        return num * num;
    }

    public static String generateHelloMessage(String name){
        if(name == null || name.trim().isEmpty()){
            return "Hello unknown";
        }
        return "Hello, " + name + "!";
    }

    public static void sayHello(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Whats your name? ");
        String name = scanner.nextLine();

        String message = generateHelloMessage(name);
        System.out.println(message);

    }
}