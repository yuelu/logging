package org.luyue.commons.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jExample {

    public static void main(String[] args) {

        // if using slf4j simple implementation, set logger level to TRACE
        // System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "TRACE");

        // if using slf4j Java logging implementation, specify path to the config file
        // System.setProperty("java.util.logging.config.file", "<Path_to_logging.properties>");

        Logger logger = LoggerFactory.getLogger(Slf4jExample.class);

        final String message = "Hello logging!";
        logger.trace(message);
        logger.debug(message);
        logger.info(message);
        logger.warn(message);
        logger.error(message);
    }
}
