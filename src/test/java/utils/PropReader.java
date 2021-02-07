package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropReader {
    private Properties prop;

    public Properties init_prop() {
        String path = System.getProperty("user.dir");
        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream(path + "/src/test/resources/config/config.properties");
            prop.load(fis);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }

    public String getProp(String key) {
        init_prop();
        return prop.getProperty(key);
    }
}
