package com.dsalgo;

public class Palindrome {
    public boolean isPalindrome(int num) {
        var str = Integer.toString(num);
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0 || x != 0 && x % 10 == 0) {
            return false;
        }

        int reversed = 0;
        int orignal = x;

        while (x != 0) {
            reversed = reversed * 10 + x % 10;
            x = x / 10;
        }
        return reversed == orignal;
    }
}
