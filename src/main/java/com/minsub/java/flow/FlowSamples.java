package com.minsub.java.flow;

import org.junit.Test;

import java.util.List;
import java.util.concurrent.Flow.*;
import java.util.concurrent.SubmissionPublisher;

public class FlowSamples {
    
    @Test
    public void sample1() throws Exception {
        Subscriber<String> subscriber = new Subscriber<>() {
            private Subscription subscription;
            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;
                subscription.request(1);
            }
    
            @Override
            public void onNext(String item) {
//                System.out.println("Got : " + Integer.valueOf(item));
                System.out.println("Got : " + item);
                subscription.request(1);
            }
    
            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
    
            @Override
            public void onComplete() {
                System.out.println("Done");
            }
        };
    
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        publisher.subscribe(subscriber);
    
        System.out.println("Publishing items...");
        List.of("1","x","2","y").stream().forEach(i -> publisher.submit(i));
        Thread.sleep(3000);
    }
}
