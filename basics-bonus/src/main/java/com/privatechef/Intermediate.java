package com.privatechef;

public class Intermediate {
    static String[] words = {"One", "Two", "Thee", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};


    public static void main(String[] args) {
        String result = findNumberInTextFormat(1);
        System.out.println(result);

        runNumbers();

    }

    public static String findNumberInTextFormat(int num) {
        if (num > 10) return "only between 1 and 10";
        return words[num - 1];
    }

    public static void runNumbers() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(findModuloNumber(i));
        }
    }

    public static String findModuloNumber(int num) {
        if(num % 3 == 0 && num % 5 == 0)return "#$" + num;
        if (num % 3 == 0) return "#" + num;
        if (num % 5 == 0) return "$" + num;
        return "" + num;
    }


}
