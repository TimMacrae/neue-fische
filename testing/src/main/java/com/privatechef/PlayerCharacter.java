package com.privatechef;

public class PlayerCharacter {
    int[] position = {0,0};

    public int getX() {
        return this.position[0];
    }

    public void setX(int x) {
        this.position[0] = x;
    }

    public int getY() {
        return this.position[1];
    }

    public void setY(int y) {
        this.position[1] = y;
    }

    public int[] getPosition() {
        return this.position;
    }

    public int[] moveW(){
        position[0]++;
        return this.position;
    }

    public int[] moveS(){
        position[0]--;
        return this.position;
    }

    public int[] moveA(){
        position[1]--;
        return position;
    }

    public int[] moveD(){
        position[1]++;
        return position;
    }

}
