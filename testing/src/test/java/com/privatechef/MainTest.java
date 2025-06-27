package com.privatechef;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    void isEven_shouldReturnTrue_whenCalledWith2 (){
        // GIVEN -> Mock data
        int number = 2;
        boolean expect = true;

        //  WHEN -> Method cal
        boolean actual = Main.isEven(number);

        // THEN -> Assertions
        assertEquals(expect,actual);
    }

    @Test
    void multiply_shouldReturnTheCorrectNumber (){
        assertEquals(50, Main.multiply(2,25));
        assertEquals(50, Main.multiply(10,5));
        assertEquals(9, Main.multiply(3,3));
    }

    @Test
    void stringToUppercase_shouldReturnAnUppercaseString(){
        assertEquals("TIM", Main.stringToUppercase("Tim"));
    }

    @Test
    void isPositive_shouldReturnTrue_whenCalledWith1 (){
        assertTrue(Main.isPositive(1));
    }

    @Test
    void isPositive_shouldReturnFalse_whenCalledWith2 (){
        assertFalse(Main.isPositive(0));
    }
}