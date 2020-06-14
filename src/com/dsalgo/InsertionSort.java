package com.dsalgo;

public class InsertionSort {
    public void sort(int[] array) {
        int lastIndex = array.length - 1;

        for(var i = 1; i <= lastIndex; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && temp < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }
}
