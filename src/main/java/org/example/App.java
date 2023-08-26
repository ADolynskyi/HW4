package org.example;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;


import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    private static final Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) throws NotCompliantMBeanException, MalformedObjectNameException,
            InstanceAlreadyExistsException, MBeanRegistrationException {

        LogManager.getRootLogger().setLevel(Level.INFO);
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

        StandardMBean mBean = new StandardMBean(new MyMBeanImpl(), MyMBean.class);

        ObjectName mBeanName = new ObjectName("com.example:type=MyBean");

        mbs.registerMBean(mBean, mBeanName);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String string = userInput(scanner);
            if (string.equals("Exit")) {
                scanner.close();
                logger.debug("Scanner is closed");
                break;
            }
            String convertedString = stringConverter(string);
            logger.info("Converted string " + convertedString);
        }

    }

    private static String userInput(Scanner scanner) {

        logger.info("Type some string");
        String string = scanner.nextLine();
        logger.debug("Typed string is: " + string);
        return string;
    }

    private static String stringConverter(String string) {
        char[] ch = string.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if (i % 2 == 0) {
                stringBuilder.append(String.valueOf(ch[i]).toLowerCase());
            } else {
                stringBuilder.append(String.valueOf(ch[i]).toUpperCase());
            }
        }
        return stringBuilder.toString();
    }
}
