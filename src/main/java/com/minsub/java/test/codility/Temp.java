package com.minsub.java.test.codility;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/*


*/
public class Temp {
    
    @Test
    public void run() {

        System.out.println("expected: 2, actual: " + solution(new int[]{4,3,2,1,5}, new int[]{0,1,0,0,0}));

    }

    public int solution(int[] A, int[] B) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i=0 ; i<A.length; i++) {
            if (B[i] == 0) {
                if (stack.isEmpty()) {
                    count++;
                    continue;
                } else {
                    while(!stack.isEmpty() && A[i] > stack.peek()) {
                        stack.pop();
                    }
                    if (stack.isEmpty()) {
                        count++;
                    }
                }
            } else {
                stack.push(A[i]);
            }
        }
        return count + stack.size();
    }

}
