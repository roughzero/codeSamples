/*
 * Created on 2015年11月17日
 */
package sample.java.lang;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SampleOfProperties {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        File file = new File("test.properties");
        InputStream is = new FileInputStream(file);
        properties.load(is);
        System.out.println(properties.getProperty("test"));
        properties.load(ClassLoader.getSystemResourceAsStream("log4j.properties"));
        System.out.println(properties.getProperty("log4j.logger.sample"));
    }
}
