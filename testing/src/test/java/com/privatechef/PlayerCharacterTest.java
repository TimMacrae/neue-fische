package com.privatechef;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerCharacterTest {
    private PlayerCharacter player;

    @BeforeEach
    void setUp() {
        player = new PlayerCharacter();
        player.setX(0);
        player.setY(0);
    }


    @Test
    void getX_shouldReturn0(){
        assertEquals(0, player.getX());
    }

    @Test
    void getY_shouldReturn0(){
        assertEquals(0, player.getY());
    }

    @Test
    void moveW_shouldReturn01(){
        int[] expected = {1,0};
        assertArrayEquals(expected, player.moveW());
    }

    @Test
    void moveS_shouldReturn0minus1(){
        int[] expected = {-1,0};
        assertArrayEquals(expected, player.moveS());
    }

    @Test
    void moveA_shouldReturnMinus10(){
        int[] expected = {0,-1};
        assertArrayEquals(expected, player.moveA());
    }

    @Test
    void moveD_shouldReturn1and0(){
        int[] expected = {0,1};
        assertArrayEquals(expected, player.moveD());
    }

    @Test
    void moveAround_shouldGoUpAndRight(){
        int[] expected = {1,1};
        player.moveW();
        player.moveD();
        assertArrayEquals(expected, player.getPosition());
    }

    @Test
    void moveAround_shouldGoLeftLeftDownAndRight(){
        int[] expected = {-1,-1};
        player.moveA();
        player.moveA();
        player.moveS();
        player.moveD();
        assertArrayEquals(expected, player.getPosition());
    }

}