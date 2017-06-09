package com.minsub.java.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by hmm1115222 on 2017-06-07.
 */
public class Print5 implements Runnable {
    @Override
    public void run() {
        String tName = Thread.currentThread().getName();
        for (int i=0; i < 5; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(String.format("%d - threadName: [%s] Print !!", i+1, tName));
        }
    }
}
