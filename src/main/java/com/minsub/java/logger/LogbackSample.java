package com.minsub.java.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by hmm1115222 on 2016-12-27.
 */
public class LogbackSample {

    private static final Logger LOG = LoggerFactory.getLogger(LogbackSample.class);

    public static void main(String[] args ) {
        LOG.debug("log message 1");
        LOG.info("log message 2");
    }
}
