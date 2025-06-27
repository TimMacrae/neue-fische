package com.privatechef;

import com.github.lalyos.jfiglet.FigletFont;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int result = addition(5,5);
        System.out.println(result);

        String asciiArt = FigletFont.convertOneLine("MAVEN BABY");
        System.out.println(asciiArt);
    }

    public static int addition (int num, int num2){
        return num+num2;
    }
}