package com.minsub.java.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by jiminsub on 2017. 5. 14..
 */
public class sample {

    public static void main(String[] args) {
       int a = 1234;



        System.out.println();


        String s = Integer.toBinaryString(20);

        System.out.println(s);


        List<Integer> list = Arrays.asList(3,2,1);

        Collections.sort(list);


        System.out.println(list);




        char c = '1';
        System.out.println((int)c);
        System.out.println((int)'a' - 'a');
        System.out.println((int)'z' - 'a');

        System.out.println(c - '1');

    }
}
