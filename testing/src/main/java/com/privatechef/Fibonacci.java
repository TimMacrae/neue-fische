package com.privatechef;

public class Fibonacci {

    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n > 1) {
            int a = 0, b = 1;
            for (int i = 2; i <= n; i++) {
                int temp = a + b;
                a = b;
                b = temp;
            }
            return b;
        }

        // Manage negative numbers
        int sign = (n % 2 == 0) ? -1 : 1;
        return sign * fibonacci(-n);

    }
}
