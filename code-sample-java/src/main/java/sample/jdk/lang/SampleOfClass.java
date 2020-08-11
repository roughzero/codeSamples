/*
 * Created on 2015年7月4日
 */
package sample.jdk.lang;

public class SampleOfClass {
    @SuppressWarnings({"rawtypes"})
    public static void main(String[] args) {
        Class clazz = String.class;
        System.out.println(clazz.isInstance(""));
        System.out.println(clazz.isInstance(String.class));
        System.out.println(clazz.isAssignableFrom(String.class));
    }
}
