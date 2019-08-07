package com.minsub.java.test.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 
 There are two sorted arrays nums1 and nums2 of size m and n respectively.
 
 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 
 You may assume nums1 and nums2 cannot be both empty.
 
 Example 1:
 
 nums1 = [1, 3]
 nums2 = [2]
 
 The median is 2.0
 Example 2:
 
 nums1 = [1, 2]
 nums2 = [3, 4]
 
 The median is (2 + 3)/2 = 2.5
 */
public class FindMediumSortedArrays {
    
    @Test
    public void case1() {
        double r = findMedianSortedArrays(new int[]{1,3}, new int[]{2});
        System.out.println(r);
//        Assert.assertEquals(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}), 2.5D);
    }
    
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        list1.addAll(list2);
        Collections.sort(list1);
        if (list1.size() == 1) {
            return list1.get(0);
        } else if (list1.size() % 2 == 0) {
            int mid = list1.size() / 2;
            return (list1.get(mid) + list1.get(mid - 1)) / 2D;
        } else {
            return (double)(list1.get(list1.size() / 2));
        }
    }
}
