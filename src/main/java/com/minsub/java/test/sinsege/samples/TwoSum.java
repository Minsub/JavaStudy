package com.minsub.java.test.sinsege.samples;

import java.util.HashMap;


public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {
        int[] result = new int[2];
        for (int i=0; i < list.length - 1; i++) {
            for (int j=i + 1; j < list.length; j++) {
                if (j < list.length) {
                    if (list[i] + list[j] == sum) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }
        }
        return null;
    }

    public static int[] findTwoSum2(int[] list, int sum) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i < list.length; i++) {
            int value = sum - list[i];
            if (map.containsKey(value)) {
                result[0] = i;
                result[1] = map.get(value);
                return result;
            } else {
                map.put(list[i], i);
            }

        }
        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum2(new int[] { 1, 3, 5, 7, 9 }, 16);
        System.out.println(indices[0] + " " + indices[1]);
    }
}
