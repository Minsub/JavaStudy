package com.minsub.java.test.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class TwoSum {
    
    @Test
    public void case1() {
        int[] nums = {3, 6, 4, 1};
        Assert.assertArrayEquals(twoSum(nums, 9), new int[]{0, 1});
        Assert.assertArrayEquals(twoSum(nums, 5), new int[]{2, 3});
    }
    
    
    public int[] twoSum(int[] nums, int target) {
        for (int i=0; i<nums.length; i++) {
            if (nums[i] >= target) {
                continue;
            }
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }
}
