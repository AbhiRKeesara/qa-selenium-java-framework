package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class UtilitiesFunctions {
    private static final Logger log = LogManager.getLogger(Logger.class.getName());

    public static Properties loadFile(String fileName) {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(fileName));
        } catch (IOException e) {
            log.warn("Failed to load " + fileName + " file.");
        }

        for (EnvironmentVariables variable : EnvironmentVariables.values()) {
            if (System.getProperty(variable.name()) != null) {
                props.put(variable.name(), System.getProperty(variable.name()));
            }
        }

        return props;
    }

    public static boolean isCircleCI() {
        return Boolean.parseBoolean(System.getProperty("CIRCLECI"));
    }
}
