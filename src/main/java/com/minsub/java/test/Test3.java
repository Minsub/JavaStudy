package com.minsub.java.test;

import org.junit.Test;

import javax.swing.*;
import java.util.*;

/**
 * Created by jiminsub on 2017. 5. 14..
 */
public class Test3 {

    @Test
    public void run() {
        System.out.println("답: 3, actual: " + solution(new int[]{2,1,2,1,3,1}));
    }
    
    public int solution(int[] A) {
        Arrays.sort(A);
        return A[A.length-1] * A[A.length-2] * A[A.length-3];
    }
    
  
}
