package com.minsub.java.test;

import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by jiminsub on 2017. 5. 14..
 */
public class sample {

    public static void main(String[] args) {
    
        String s = null;
        String[] arr = StringUtils.split(s, ",");
        System.out.println(arr.length);
    
        String[] arr2 = s.split(",");
        System.out.println(arr2.length);
    }
}
