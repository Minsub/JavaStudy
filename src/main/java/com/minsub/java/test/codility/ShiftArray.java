package com.minsub.java.test.codility;

import org.junit.Test;

import java.util.Arrays;

/*


*/
public class ShiftArray {
    
    @Test
    public void run() {
        System.out.println("[3, 8, 9, 7, 6] -> [9, 7, 6, 3, 8], actual: " + Arrays.toString(solution(new int[]{3, 8, 9, 7, 6}, 3)));
        System.out.println("[1234] -> [1234], actual: " + Arrays.toString(solution(new int[]{1,2,3,4}, 5)));
        System.out.println("[0,0,0] -> [0,0,0], actual: " + Arrays.toString(solution(new int[]{0,0,0}, 1)));
    }

    public int[] solution(int[] A, int K) {
        if (A.length == K) return A;
        int c = K > A.length ? K % A.length : K;
        int[] answer = new int[A.length];
        for (int i=0; i<A.length; i++) {
            answer[i] = A[(A.length - c + i) % A.length ];
        }
        return answer;
    }
}
