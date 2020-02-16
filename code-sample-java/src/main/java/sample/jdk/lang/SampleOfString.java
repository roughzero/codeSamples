/*
 * Created on 2015年7月24日
 */
package sample.jdk.lang;

import java.io.UnsupportedEncodingException;

public class SampleOfString {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println("rough.abc".matches("rough.*"));
        System.out.println("rough.abc".matches("rough.[a-z]*"));
        System.out.println("rough.abc".matches("rough\\.[a-z]*"));
        System.out.println("rough.abc".matches("^rough\\.[a-z]*"));
        System.out.println("org.rough.abc".matches(".*rough\\.[a-z]*"));
        System.out.println("12345678".matches("\\d*"));
        System.out.println("com.guohualife.tip.abc".matches("com\\.guohualife\\.tip.*"));
        System.out.println("：".getBytes("GBK").length);
        System.out.println("：".getBytes("UTF-8").length);
        System.out.println("：".getBytes("ISO-8859-1").length);
        System.out.println(OutOfMemoryError.class.getName().matches("java.*Error"));
        System.out.println("1234567890".substring(0, 6));
        String s = "2018-02-28-银代手续费-BAT00000000000004392-出单费-借-正常 单据号:BAT00000000000004392_YFWFY";
        System.out.println(s.substring(0, s.indexOf("单据号:")));
        System.out.println(s.substring(s.indexOf("单据号:") + 4));
    }
}
