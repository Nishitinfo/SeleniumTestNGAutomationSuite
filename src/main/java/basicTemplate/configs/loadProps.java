package basicTemplate.configs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class loadProps {

    public static String getProperty(String key) {
        Properties prop = new Properties();
        FileInputStream input;

        try {
            input = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//configurations.properties");
            prop.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }

    public static void setProperty(String key, String Value) {
        try {
            // Load the properties file
            FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//configurations.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            inputStream.close();

            // Print original property value
            String originalValue = properties.getProperty("Version");
            System.out.println("Original Property Value: " + originalValue);

            // Update (rename) the property value
            properties.setProperty("Version", Value);

            // Save the updated properties back to the file
            FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.dir") + "//src//test//resources//configurations.properties");
            properties.store(outputStream, null);
            outputStream.close();

            System.out.println("Property updated successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
