package com.minsub.java.test.programers;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43238
 * n명이 입국심사를 위해 줄을 서서 기다리고 있습니다. 각 입국심사대에 있는 심사관마다 심사하는데 걸리는 시간은 다릅니다.
 *
 * 처음에 모든 심사대는 비어있습니다. 한 심사대에서는 동시에 한 명만 심사를 할 수 있습니다. 가장 앞에 서 있는 사람은 비어 있는 심사대로 가서 심사를 받을 수 있습니다. 하지만 더 빨리 끝나는 심사대가 있으면 기다렸다가 그곳으로 가서 심사를 받을 수도 있습니다.
 *
 * 모든 사람이 심사를 받는데 걸리는 시간을 최소로 하고 싶습니다.
 *
 * 입국심사를 기다리는 사람 수 n, 각 심사관이 한 명을 심사하는데 걸리는 시간이 담긴 배열 times가 매개변수로 주어질 때, 모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 입국심사를 기다리는 사람은 1명 이상 1,000,000,000명 이하입니다.
 * 각 심사관이 한 명을 심사하는데 걸리는 시간은 1분 이상 1,000,000,000분 이하입니다.
 * 심사관은 1명 이상 100,000명 이하입니다.
 * 입출력 예
 * n	times	return
 * 6	[7, 10]	28
 * 입출력 예 설명
 * 가장 첫 두 사람은 바로 심사를 받으러 갑니다.
 *
 * 7분이 되었을 때, 첫 번째 심사대가 비고 3번째 사람이 심사를 받습니다.
 *
 * 10분이 되었을 때, 두 번째 심사대가 비고 4번째 사람이 심사를 받습니다.
 *
 * 14분이 되었을 때, 첫 번째 심사대가 비고 5번째 사람이 심사를 받습니다.
 *
 * 20분이 되었을 때, 두 번째 심사대가 비지만 6번째 사람이 그곳에서 심사를 받지 않고 1분을 더 기다린 후에 첫 번째 심사대에서 심사를 받으면 28분에 모든 사람의 심사가 끝납니다.
 */
public class Imigration {
    
    @Test
    public void run() {
        Imigration job = new Imigration();
        long result1 = job.solution(6,  new int[]{7, 10});
        System.out.println("정답은 28. answer is " + result1);
    
        long result2 = job.solution(4,  new int[]{2, 4, 20});
        System.out.println("정답은 6. answer is " + result2);
    }
    
    public long solution(int n, int[] times) {
        long answer = 0;
        times = Arrays.stream(times).sorted().toArray();
        int[] buffer = new int[times.length];
        int term = times[0];
        while(n > 0) {
            int emptyCount = 0;
            for (int i=0; i< times.length; i++) {
                if (buffer[i] == 0) {
                    if (emptyCount == 0) {
                        if (i != 0 && ((buffer[i-1] + times[i-1]) * n < times[i])) {
                            term = buffer[i-1];
                            break;
                        }
                        buffer[i] = times[i];
                    }
                    emptyCount++;
                } else {
                    if (buffer[i] < term) {
                        term = buffer[i];
                    }
                }
            }
    
            if (emptyCount == 0) {
                answer += term;
                for (int i=0; i< buffer.length; i++) {
                    buffer[i] = buffer[i] - term;
                    if (buffer[i] < 0) {
                        buffer[i] = 0;
                    }
                }
                term = Integer.MAX_VALUE;
            } else {
                n--;
            }
        }
        
        return answer + Arrays.stream(buffer).max().orElse(0);
    }
}
