/*
 * Created on 2013-4-7
 */
package sample.java.lang;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class SampleSystem {
    public static void main(String[] args) throws IOException, InterruptedException {
        //        String path = "D:\\rough\\tmp\\123456~1.SQL";
        //        File file = new File(path);
        //        System.out.println(file.getPath());
        //        System.out.println(file.getAbsolutePath());
        //        System.out.println(file.getCanonicalFile().getAbsolutePath());
        List<String> tmp = new ArrayList<String>();
        for (int i = 0; i < 1000000; i++) {
            tmp.add("1234567890");
        }
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        Properties properties = System.getProperties();
        Set<Object> keys = properties.keySet();
        for (Object key : keys) {
            System.out.println(key + "=" + properties.get(key));
        }
        System.out.println(5 % 2);
    }
}
