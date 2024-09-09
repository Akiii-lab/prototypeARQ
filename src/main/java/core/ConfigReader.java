package core;

import java.util.Properties;

public class ConfigReader {
    private Properties properties = new Properties();

    public ConfigReader() {
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
    
}
