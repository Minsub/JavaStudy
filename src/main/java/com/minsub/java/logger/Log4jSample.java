package com.minsub.java.logger;

import org.apache.log4j.Logger;

/**
 * Created by hmm1115222 on 2016-12-27.
 */
public class Log4jSample {

    private static Logger LOG = Logger.getLogger(Log4jSample.class);

    public static void main(String[] args ) {
        System.out.println("AAAA");
        LOG.info("log message 1");
        LOG.error("log message error 2");
    }
}
