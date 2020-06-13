package com.dsalgo;

public class BubbleSort {
    public void RawBubbleSort(int[] A) {
        int lastIndex = A.length - 1;
        for(int i = lastIndex; i >= 1; i--) {
            for(int j = 1; j <= i; j++) {
                if (A[j - 1] > A[j]) {
                    swap(A, j - 1, j);
                }
            }
        }
    }

    public void optimizedBubbleSort(int[] arr) {
        int n = arr.length;
        int i = n - 1;
        while (i > 0) {
            int t = 1;
            for(int j = 1; j <= i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    t = j;
                }
            }
            i = i - 1;
        }
    }

   private void swap(int[] arr, int first, int second) {
        int temp  = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
   }
}
