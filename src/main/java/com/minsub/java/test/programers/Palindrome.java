package com.minsub.java.test.programers;

import org.junit.Test;

public class Palindrome {
    
    @Test
    public void run() {
        String s = "abcdefghjkkuuuu";
        System.out.println(solution(s));
    }
    
    public int solution(String s) {
        int answer = 1;
        char[] arr = s.toCharArray();
        for (int i=0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i+1]) {
                answer = Math.max(answer, (Math.max(palindromeCount(arr, i - 1, i + 2) + 1, palindromeCount(arr, i - 1, i + 1))));
            } else {
                answer = Math.max(answer, palindromeCount(arr, i - 1, i + 1));
            }
        }
        return answer;
    }
    
    public int palindromeCount(char[] array, int left, int right) {
        int count = 1;
        while (left >= 0 && right < array.length) {
            if (array[left--] != array[right++]) {
                return count;
            }
            count+=2;
        }
        return count;
    }
}
