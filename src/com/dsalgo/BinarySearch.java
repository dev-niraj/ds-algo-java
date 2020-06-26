package com.dsalgo;

public class BinarySearch {
    public int binarySearchI(int[] nums, int x) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (nums[m] == x)
                return m;

            if (nums[m] < x)
                l = m + 1;
            else
                r = m - 1;
        }

        return -1;
    }

    public int binarySearchR(int[] nums, int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == x)
                return mid;

            if (nums[mid] > x)
                return binarySearchR(nums, l, mid - 1, x);

            return binarySearchR(nums, mid + 1, r, x);
        }

        return -1;
    }
}
