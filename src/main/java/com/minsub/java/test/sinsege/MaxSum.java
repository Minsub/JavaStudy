package com.minsub.java.test.sinsege;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxSum {
    public static int findMaxSum(List<Integer> list) {
        int max = 0, max2 = 0;
        for (Integer v: list) {
            if (max <= v) {
                max2 = max;
                max = v;
            } else if (max2 < v) {
                max2 = v;
            }
        }
        return max + max2;
    }

    public static int findMaxSum2(List<Integer> list) {
        Collections.sort(list);
        return list.get(list.size() -1) + list.get(list.size() -2);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 9, 7, 11);
        System.out.println(findMaxSum(list));
    }
}