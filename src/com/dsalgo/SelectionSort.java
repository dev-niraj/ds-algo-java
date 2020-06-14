package com.dsalgo;

public class SelectionSort {
    public void sort(int[] array) {
        int lastIndex = array.length - 1;

        for(int i = lastIndex; i >= 1; i--) {
            int indexOfItemToPlace = 0;
            for(int j = 1; j <= i; j++) {
                if (array[j] > array[indexOfItemToPlace]) {
                    indexOfItemToPlace = j;
                }
            }
            swap(array, indexOfItemToPlace, i);
        }
    }

    private void swap(int[] arr, int first, int second) {
        int temp  = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
