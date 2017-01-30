package com.minsub.java.kafka.consumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by jiminsub on 2017. 1. 8..
 */
public class ConsumerStarter {
//    private static final String TOPIC = "consumer-tutorial";
//    private static final String CONSUMER_GROUP = "consumer-tutorial-group";
//    private static final String BOOTSTRAP_SERVERS = "localhost:9092";
    private static final String TOPIC = "metric";
    private static final String CONSUMER_GROUP = "metric-group";
    private static final String BOOTSTRAP_SERVERS = "192.168.0.16:9092,192.168.0.18:9092";

    public static void main(String[] args) {
        int numConsumers = 4;
        List<String> topics = Arrays.asList(TOPIC);
        ExecutorService executor = Executors.newFixedThreadPool(numConsumers);

        final List<ConsumerLoop> consumers = new ArrayList<>();
        for (int i = 0; i < numConsumers; i++) {
            ConsumerLoop consumer = new ConsumerLoop(i, BOOTSTRAP_SERVERS, CONSUMER_GROUP, topics);
            consumers.add(consumer);
            executor.submit(consumer);
        }

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                for (ConsumerLoop consumer : consumers) {
                    consumer.shutdown();
                }
                executor.shutdown();
                try {
                    executor.awaitTermination(5000, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
