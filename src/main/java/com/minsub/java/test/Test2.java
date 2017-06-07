package com.minsub.java.test;

/**
 * Created by jiminsub on 2017. 5. 14..
 */
public class Test2 {


    public static void main(String[] args) {
        int a = 11;

        int v = a;
        int cnt = 0;
        while(v > 0) {
            cnt += (v & 1);
            v >>= 1;
        }

        System.out.println(a + " : " + Integer.toBinaryString(a) + ", cnt: "+cnt);


        System.out.println(7 & 1);

        System.out.println( 5 / 10);
    }
}
