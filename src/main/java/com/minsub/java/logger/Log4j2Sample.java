package com.minsub.java.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by hmm1115222 on 2016-12-27.
 */
public class Log4j2Sample {
    private static final Logger LOG = LogManager.getLogger();

    public static void main(String[] args ) {
        LOG.info("log4j2 message 1");
        LOG.error("log4j2 message 2");
    }
}
