package com.minsub.java.test.sinsege.samples;


public class Palindrome {
    public static boolean isPalindrome(String word) {
        String tmp = word.toUpperCase();
        for (int i=0; i < tmp.length() / 2; i++) {
            if (tmp.charAt(i) != tmp.charAt(tmp.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(com.minsub.java.test.sinsege.sample.Palindrome.isPalindrome("Deleveled"));
    }
}
