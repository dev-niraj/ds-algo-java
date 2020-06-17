package com.dsalgo;

import java.util.HashSet;
import java.util.Set;

public class singleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int n : nums) {
            result ^= n;
        }
        return result;
    }

    public int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            System.out.println(set);
            if (!set.add(num)) {
                set.remove(num);
            }
        }

        return set.iterator().next();
    }
}
