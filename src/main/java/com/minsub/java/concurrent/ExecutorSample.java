package com.minsub.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by hmm1115222 on 2017-06-07.
 */
public class ExecutorSample {

    public static void main(String[] args) {
        System.out.println("START SAMPLE 1");

        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            executor.submit(new Print5());

            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        } finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }

        System.out.println("END SAMPLE 1");
    }
}
