package com.minsub.java.test.leetcode;

import org.junit.Test;

/**
 Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 
 Example 1:
 
 Input: "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.
 Example 2:
 
 Input: "cbbd"
 Output: "bb"
 */
public class LongestPalindromic {
    
    @Test
    public void case1() {
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ab"));
        System.out.println(longestPalindrome("aa"));
        
    }
    
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        char[] arr = s.toCharArray();
        int maxCnt = 0, index = 0;
        for (int i=0; i < arr.length - 1; i++) {
            int max = Math.max(count(arr, i - 1, i + 1), arr[i] == arr[i+1] ? count(arr, i - 1, i + 2) + 1 : 0);
            if (maxCnt < max) {
                maxCnt = max;
                index = i;
            }
        }
        return s.substring(index - (maxCnt / 2 -(maxCnt % 2 == 0 ? 1 : 0)), index + (maxCnt / 2) + 1);
    }
    
    public int count(char[] arr, int left, int right) {
        int cnt = 1;
        while(left >= 0 && right < arr.length) {
            if (arr[left--] != arr[right++]) {
                return cnt;
            }
            cnt+=2;
        }
        return cnt;
    }
}
