/*
 * Created on 2017年1月18日
 */
package sample.jdk.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SampleOfMap {
    public static Map<String, String> testMap = new ConcurrentHashMap<String, String>();
    public static final String KEY_17 = "TL001F,2017-01-17";
    public static final String KEY_18 = "TL001F,2017-01-18";

    public static void main(String[] args) {
        testMap.put(KEY_17, KEY_17);
        testMap.put(KEY_18, KEY_18);

        Thread[] threads = new Thread[10];

        for (Thread thread : threads) {
            thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        System.out.println(KEY_17 + ":" + testMap.get(KEY_17));
                        System.out.println(KEY_18 + ":" + testMap.get(KEY_18));
                    }
                }
            });

            thread.start();
        }
    }
}
