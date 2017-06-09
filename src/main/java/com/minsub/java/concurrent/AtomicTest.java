package com.minsub.java.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hmm1115222 on 2017-06-09.
 */
public class AtomicTest {

    public static void main(String[] args) {
        AtomicInteger atomicInt = new AtomicInteger(0);

        for (int i=0; i < 10; i++) {
            atomicInt.updateAndGet(operand -> operand + 1);
        }

        System.out.println(atomicInt);
    }
}
