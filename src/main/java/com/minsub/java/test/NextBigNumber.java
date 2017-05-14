package com.minsub.java.test;

/**
 * Created by jiminsub on 2017. 5. 13..
 */
public class NextBigNumber {

    String caesar(String s, int n) {
        StringBuilder sb = new StringBuilder();

        if (n > 26) {
            n = n % 26;
        }

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            int tmp;
            if (c == ' ') {
                sb.append(c);
            } else {
                tmp = c + n;
                if ((c <= 90 && tmp > 90) || (c >= 97 && tmp > 122)) {
                    sb.append((char)(tmp-26));
                } else {
                    sb.append((char)tmp);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        NextBigNumber c = new NextBigNumber();
        System.out.println("s는 'a B z', n은 4인 경우: " + c.caesar("a B z", 32));
    }
}
