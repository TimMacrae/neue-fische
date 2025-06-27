package com.privatechef;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntermediateTest {

    @Test
    void findNumberInTextFormat_shouldReturnTheCorrectText(){
        assertEquals("One", Intermediate.findNumberInTextFormat(1));
        assertEquals("only between 1 and 10", Intermediate.findNumberInTextFormat(11));
    }

    @Test
    void findModuloNumber_shouldReturnTheCorrectNumber(){
        assertEquals("11", Intermediate.findModuloNumber(11));
        assertEquals("#9", Intermediate.findModuloNumber(9));
        assertEquals("$20", Intermediate.findModuloNumber(20));
        assertEquals("#$15", Intermediate.findModuloNumber(15));
    }
}