package com.minsub.java.logger.kafka;

import org.apache.log4j.Logger;

/**
 * Created by hmm1115222 on 2016-12-27.
 */
public class KafkaLog4jSample {

    private static Logger LOG = Logger.getLogger(KafkaLog4jSample.class);

    public static void main(String[] args ) {
        LOG.info("Kafka log message 1");
        LOG.error("Kafka log message 2");
    }
}
