package com.dsalgo;

public class pairOfSum {
    public int addition(int n1, int n2) {
        int x = n1, y = n2;
        int xor, and, temp;
        and = x & y;
        xor = x ^ y;

        while (and != 0) {
            and <<= 1;
            temp = xor ^ and;
            and &= xor;
            xor = temp;
        }

        return xor;
    }

    public int multiply(int n1, int n2) {
        int temp, i = 0, result = 0;

        while (n2 != 0) {
            if ((n2 & 1) == 1) {
                temp = n1;
                result += (temp<<=i);
            }

            n2 >>= 1;   // Right shift n2 by 1.
            i++;
        }

        return result;
    }
}
