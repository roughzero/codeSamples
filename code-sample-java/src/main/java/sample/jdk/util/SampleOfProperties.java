/*
 * Created on 2017年12月26日
 */
package sample.jdk.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SampleOfProperties {
    public static void main(String[] args) {
        Properties prop = new Properties();
        try {
            InputStream in = ClassLoader.getSystemResourceAsStream("001.properties");
            prop.load(in);
            for (String key : prop.stringPropertyNames()) {
                System.out.println(key + ":" + prop.getProperty(key));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
