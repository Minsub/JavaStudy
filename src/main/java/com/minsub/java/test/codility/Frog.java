package com.minsub.java.test.codility;

import org.junit.Test;

import java.util.Arrays;

/*


*/
public class Frog {
    
    @Test
    public void run() {
        System.out.println("3, 999111321 7 expected: 142730189, actual: " + solution(3, 999111321, 7));
    }

    public int solution(int X, int Y, int D) {
        //return (int)Math.ceil((Y - X) / (float)D);
        int answer = (Y - X) / D;
        if ((Y - X) % D > 0) {
            return answer + 1;
        }
        return answer;
    }
}
