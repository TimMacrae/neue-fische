package com.privatechef;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "2, 1",
            "3, 2",
            "4, 3",
            "5, 5",
            "6, 8",
            "7, 13",
            "8, 21",
            "-1, 1",
            "-2, -1",
            "-3, 2",
            "-4, -3",
            "-5, 5",
            "-6, -8",
            "-7, 13"
    })
    public void testFibonacci(int n, int expected) {
        assertEquals(expected, Fibonacci.fibonacci(n));
    }

}