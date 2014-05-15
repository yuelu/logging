package org.luyue.commons.logging;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class JavaLogging {

    public static void main(String[] args) {

        final String message = "Hello from java.util.logging.";

        testConsoleHandler(message);
        testFildHandler(message);
    }

    public static void testConsoleHandler(final String message) {

        Logger logger = Logger.getAnonymousLogger();

        // configure a console handler
        ConsoleHandler consoleHandler = new ConsoleHandler();

        // set level to All so that we are able to see messages of all levels.
        // Default level of ConsoleHandler is SEVERE, WARNING, INFO
        consoleHandler.setLevel(Level.ALL);

        // disable parent handlers so that we only see the output from above configured console handler
        logger.setUseParentHandlers(false);

        // add console handler to the logger
        logger.addHandler(consoleHandler);

        // set level to All so that we are able to see messages of all levels.
        logger.setLevel(Level.ALL);

        logMessag(logger, message);
    }

    public static void testFildHandler(final String message) {

        Logger logger = Logger.getAnonymousLogger();

        FileHandler fileHandler;
        try {
            // create a file handler
            fileHandler = new FileHandler("myLog.log", false);

            // set formatter of the file handler. If not set, default is XMLFormatter
            fileHandler.setFormatter(new SimpleFormatter());

            // add file handler to the logger
            logger.addHandler(fileHandler);

            // set level to All so that we are able to see messages of all levels.
            logger.setLevel(Level.ALL);

            // disable parent handlers so that we only see the output from above configured file handler
            logger.setUseParentHandlers(false);

            logMessag(logger, message);

        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void logMessag(final Logger logger, final String message) {
        logger.severe(message);
        logger.warning(message);
        logger.info(message);
        logger.config(message);
        logger.fine(message);
        logger.finer(message);
        logger.finest(message);
    }
}
