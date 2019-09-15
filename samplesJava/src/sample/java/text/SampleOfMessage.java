/*
 * Created on 2015年11月20日
 */
package sample.java.text;

import java.text.MessageFormat;

public class SampleOfMessage {
    public static void main(String[] args) {
        String result = MessageFormat.format("Test message, {0}, {1}", "Hello", "World");
        System.out.println(result);
    }
}
