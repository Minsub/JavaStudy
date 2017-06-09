package com.minsub.java.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by hmm1115222 on 2017-06-07.
 */
public class CallablePrint5 implements Callable<List<String>> {
    @Override
    public List<String> call() throws Exception {
        String tName = Thread.currentThread().getName();
        for (int i=0; i < 5; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(String.format("%d - threadName: [%s] Print !!", i+1, tName));
        }
        return Arrays.asList("A","B","C");
    }
}
