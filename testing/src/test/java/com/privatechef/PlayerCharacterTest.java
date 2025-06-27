package com.privatechef;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerCharacterTest {

    @Test
    void getX_shouldReturn0(){
        assertEquals(0, PlayerCharacter.getX());
    }

}