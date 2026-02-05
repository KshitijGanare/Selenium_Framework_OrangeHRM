package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetProperty {

    public static String getPropertyValue(String key) throws IOException {

        FileInputStream file = new FileInputStream("src/main/java/config/config.properties");
        Properties prop = new Properties();
        prop.load(file);
        return prop.getProperty(key);

    }

}
