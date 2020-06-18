package com.dsalgo;

import com.sun.source.tree.BreakTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class fibonacci {
    public long fib(int N) {
        if (N < 2) {
            return N;
        }

        int a = 0;
        int b = 1;

        while (N-- > 1) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public long fibTraditional(long n) {
        if (n <= 1)
            return n;

        return fibTraditional(n - 1) + fibTraditional(n - 2);
    }

    public int fibMemoization(int n) {
        HashMap<Integer, Integer> mmap = new HashMap<>();
        mmap.put(0,0);
        mmap.put(1,1);

        return fibMemoization(n, mmap);
    }

    private int fibMemoization(int n, Map<Integer, Integer> mmap) {
        if (mmap.containsKey(n)) {
            return mmap.get(n);
        }

        int fibFromN = fibMemoization(n - 1, mmap) + fibMemoization(n - 2, mmap);
        mmap.put(n, fibFromN);
        return fibFromN;
    }
}
