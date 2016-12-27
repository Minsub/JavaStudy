package com.minsub.java.kafka;

import org.apache.log4j.Logger;


public class KafkaAppenderSample {

    private static Logger LOG = Logger.getLogger(KafkaAppenderSample.class);

    public static void main(String[] args) {
        LOG.info("test kafka appender test1");
        LOG.error("test kafka appender test2 in error");




    }
}
