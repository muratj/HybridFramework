package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropReader {
    private static Properties prop;

    public static void init_prop() {
        String path = System.getProperty("user.dir");
        prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream(path + "/src/test/resources/config/config.properties");
            prop.load(fis);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProp(String key) {
        init_prop();
        return prop.getProperty(key);
    }
}
