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
}