package com.dsalgo;

public class ReverseInteger {
    public int reverse(int n) {
        int result = 0;
        String s = "test";
        while (n != 0) {
            int lastDigit = n % 10;
            int newResult = result * 10 + lastDigit;
            if ((newResult - lastDigit) / 10 != result) {
                return 0;
            }
            n /= 10;
            result = newResult;
        }

        return result;
    }
}
