package com.dsalgo;

public class QuickSort {
    public void quickSort(int[] nums, int start, int end) {
        if (start >= end)
            return;

        var boundary = partition(nums, start, end);
        quickSort(nums, start, boundary - 1);
        quickSort(nums, boundary + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        var pivot = nums[end];
        var boundary = start - 1;

        for(var i = start; i <= end; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, ++boundary);
            }
        }

        return boundary;
    }

    private void swap(int[] arr, int first, int second) {
        int temp  = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
