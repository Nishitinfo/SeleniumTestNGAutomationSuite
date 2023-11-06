package basicTemplate;

import java.io.FileInputStream;
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
}
