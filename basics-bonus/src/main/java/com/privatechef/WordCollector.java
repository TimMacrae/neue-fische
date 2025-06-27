package com.privatechef;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCollector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();

        System.out.println("Insert Words, to end the program type (\"stop\"):");

        while(true){
            allInsertedWords(words);

            System.out.print("New Word: ");
            String newWord = scanner.nextLine().trim();

            if (newWord.equalsIgnoreCase("stop")) {
                break;
            }

            if (!newWord.isEmpty()) {
                words.add(newWord);
            }

        }

    }

    public static String formatWords(ArrayList<String> words) {
        if (words.isEmpty()) {
            return "(no words jet)";
        }
        return String.join(", ", words);
    }

    public static void allInsertedWords(ArrayList<String> words) {
        System.out.println("All Words: " + formatWords(words));
    }

}
