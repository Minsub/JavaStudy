package com.minsub.java.test.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 Write a function to find the longest common prefix string amongst an array of strings.
 
 If there is no common prefix, return an empty string "".
 
 Example 1:
 
 Input: ["flower","flow","flight"]
 Output: "fl"
 Example 2:
 
 Input: ["dog","racecar","car"]
 Output: ""
 Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {
    
    @Test
    public void case1() {
        String[] case1 = {"flower","flow","flight"};
        Assert.assertEquals("fl", doit(case1));
        String[] case2 = {"aca","cba"};
        Assert.assertEquals("", doit(case2));
    }
    
    
    public static String doit(String[] arr) {
        if (arr.length == 0) return "";
        if (arr.length == 1) return arr[0];
        String main = arr[0];
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < main.length(); i++) {
            char mainChar = main.charAt(i);
            for (int j=1; j < arr.length; j++) {
                if (arr[j].length() <= i) return sb.toString();
                char c = arr[j].charAt(i);
                if (mainChar != c) return sb.toString();
                if (j == arr.length - 1) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
