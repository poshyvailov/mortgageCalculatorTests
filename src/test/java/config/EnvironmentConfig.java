package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentConfig {

    private static final Properties properties = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("src/test/resources/environment.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            System.err.println("ERROR: The properties file is missing or cannot be loaded! " + e.getMessage());
            throw new IllegalStateException("Failed to load environment properties", e);
        }
    }

    public static String getProperty(String key) {
        return System.getProperty(key, properties.getProperty(key));
    }

    public static String getBrowser() {
        return getProperty("browser");
    }

    public static String getBaseUrl() {
        return getProperty("base.url");
    }
}
