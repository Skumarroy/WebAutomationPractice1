package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties;

    static {
        try (FileInputStream inputStream = new FileInputStream("C:\\Users\\sanjeet.kumar2\\IdeaProjects\\WebAutomationPractice1\\src\\test\\java\\configfiles\\config.properties")) {
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
