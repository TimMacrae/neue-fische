package com.ecosystem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {
    @Test
    public void testUnsortedArray() {
        int[] input = {5, 2, 9, 1, 5, 6};
        int[] expected = {1, 2, 5, 5, 6, 9};
        BubbleSort.bubbleSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testAlreadySortedArray() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        BubbleSort.bubbleSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testArrayWithDuplicates() {
        int[] input = {3, 3, 2, 1, 2};
        int[] expected = {1, 2, 2, 3, 3};
        BubbleSort.bubbleSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testEmptyArray() {
        int[] input = {};
        int[] expected = {};
        BubbleSort.bubbleSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testSingleElementArray() {
        int[] input = {42};
        int[] expected = {42};
        BubbleSort.bubbleSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testAllSameElements() {
        int[] input = {7, 7, 7, 7};
        int[] expected = {7, 7, 7, 7};
        BubbleSort.bubbleSort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testNegativeNumbers() {
        int[] input = {4, -1, 2, 0, -3};
        int[] expected = {-3, -1, 0, 2, 4};
        BubbleSort.bubbleSort(input);
        assertArrayEquals(expected, input);
    }
}