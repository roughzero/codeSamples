/*
 * Created on 2018年8月3日
 */
package sample.jdk.lang.reflect;

public class SampleOfClass {
    public static void main(String[] args) {
        System.out.println(String.class.isAssignableFrom(Object.class));
        System.out.println(Object.class.isAssignableFrom(String.class));
    }
}
