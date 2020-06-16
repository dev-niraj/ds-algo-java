package com.dsalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> uniqueTriplets = new ArrayList<>();

        int i, j, k;
        int len = nums.length;

        for(i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for(j = i + 1; j < len; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                for(k = j + 1; k < len; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) continue;
                    if ((nums[i] + nums[j] + nums[k]) == 0) {
                        ArrayList<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);;
                        uniqueTriplets.add(l);
                    }
                }
            }
        }
        return uniqueTriplets;
    }

    public List<List<Integer>> threeSumImproved(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (j < k) {
                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }

                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    result.add(l);
                    j++;
                    k--;
                }
            }
        }
        return result;
    }
}
