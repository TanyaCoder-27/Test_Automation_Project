//I externalized environment details in a config.properties file and used a utility class to read them.
package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    Properties prop;

    public ReadConfig() {

        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBaseURL() {
        return prop.getProperty("baseURL");
    }

    public String getBrowser() {
        return prop.getProperty("browser");
    }
}
