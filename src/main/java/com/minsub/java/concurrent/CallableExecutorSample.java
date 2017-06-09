package com.minsub.java.concurrent;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by hmm1115222 on 2017-06-07.
 */
public class CallableExecutorSample {

    public static void main(String[] args) {
        System.out.println("START SAMPLE 1");

        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            Future<List<String>> future = executor.submit(new CallablePrint5());

            System.out.println("future done? " + future.isDone());

            List<String> result = future.get();

            System.out.println("future done? " + future.isDone());
            System.out.println("result: " + result);

            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);

        } catch (InterruptedException | ExecutionException e) {
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
