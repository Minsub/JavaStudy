package com.minsub.java.test.samples;


import java.util.HashMap;

/**
 # Question
 Sherlock considers a string, , to be valid if either of the following conditions are satisfied:

 All characters in  have the same exact frequency (i.e., occur the same number of times). For example,  is valid, but  is not valid.
 Deleting exactly  character from  will result in all its characters having the same frequency. For example,  and  are valid because all their letters will have the same frequency if we remove  occurrence of c, but  is not valid because we'd need to remove  characters.
 Given , can you determine if it's valid or not? If it's valid, print YES on a new line; otherwise, print NO instead.

 Input Format

 A single string denoting .

 Constraints

 String S consists of lowercase letters only (i.e., [a-z]).
 Output Format

 Print YES if string  is valid; otherwise, print NO instead.

 Sample Input 0
 aabbcd

 Sample Output 0
 NO

 Explanation 0

 We would need to remove two characters from  to make it valid, because a and b both have a frequency of  and c and d both have a frequency of . This means  is invalid because we'd need to remove more than  character to make all its letters have the same frequency, so we print NO as our answer.
 */
public class SherlockAndTheValidString {

    static String isValid(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        HashMap<Integer, Integer> mapValues = new HashMap<>();
        for (Integer v: map.values()) {
            if (mapValues.containsKey(v)) {
                mapValues.put(v, mapValues.get(v) + 1);
            } else {
                mapValues.put(v, 1);
            }
        }

        if (mapValues.size() > 2 || mapValues.size() == 0) {
            return "NO";
        } else if (mapValues.size() == 1) {
            return "YES";
        } else {
            int cntOver2 = 0;
            for (Integer v: mapValues.values()) {
                if (v > 1) {
                    cntOver2++;
                }
            }
            return cntOver2 > 1 ? "NO" : "YES";
        }
    }

    public static void main(String[] args) {
        String s;
        String result;

        s = "aabbcc";
        result = isValid(s);
        System.out.println(s + " : " + result);

        s = "aabbccc";
        result = isValid(s);
        System.out.println(s + " : " + result);

        s = "aazbby";
        result = isValid(s);
        System.out.println(s + " : " + result);


        s = "aazbby";
        result = isValid(s);
        System.out.println(s + " : " + result);
    }
}
