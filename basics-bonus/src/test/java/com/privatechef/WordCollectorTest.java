package com.privatechef;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class WordCollectorTest {

    @Test
    public void formatWords_shouldReturnNoWordsJet() {
        ArrayList<String> words = new ArrayList<>();
        assertEquals("(no words jet)", WordCollector.formatWords(words));
    }

    @Test
    public void formatWords_shouldReturnWordsList() {
        ArrayList<String> words = new ArrayList<>();
        words.add("Toast");
        words.add("Banana");
        assertEquals("Toast, Banana", WordCollector.formatWords(words));
    }
}