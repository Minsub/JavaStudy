package com.minsub.java.logger.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by hmm1115222 on 2016-12-27.
 */
public class KafkaLogbackSample {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaLogbackSample.class);

    public static void main(String[] args ) {
        LOG.debug("Kafka log message 1");
        LOG.info("Kafka log message 2");
    }
}
