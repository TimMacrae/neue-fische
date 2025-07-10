package com.ecosystem;

public class StringAndPrime {
    // 1. Method to reverse a given string
    public static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    // 2. Method to check if a string is a palindrome
    public static boolean isPalindrome(String input) {
        String reversed = reverseString(input);
        return input.equals(reversed);
    }

    // 3. Method to generate the first n prime numbers
    public static int[] generateFirstNPrimes(int n) {
        int[] primes = new int[n];
        int count = 0;
        int number = 2;
        while (count < n) {
            if (isPrime(number)) {
                primes[count] = number;
                count++;
            }
            number++;
        }
        return primes;
    }

    // Helper method to check if a number is prime
    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test reverseString
        System.out.println("Reversed 'Hello': " + reverseString("Hello"));

        // Test isPalindrome
        System.out.println("'anna' is a palindrome? " + isPalindrome("anna"));
        System.out.println("'hello' is a palindrome? " + isPalindrome("hello"));

        // Test generateFirstNPrimes
        int[] primes = generateFirstNPrimes(10);
        System.out.print("First 10 prime numbers: ");
        for (int prime : primes) {
            System.out.print(prime + " ");
        }
    }
}
