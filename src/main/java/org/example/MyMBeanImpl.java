package org.example;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class MyMBeanImpl implements MyMBean {
    private static final Logger logger = Logger.getLogger(MyMBeanImpl.class);
    @Override
    public void changeLogLevelInfo() {
        LogManager.getRootLogger().
                setLevel(Level.DEBUG);

        logger.info("Change log level to DEBUG");
    }
    @Override
    public void changeLogLevelDebug() {
        LogManager.getRootLogger().
                setLevel(Level.INFO);

        logger.info("Change log level to INFO");
    }
}
