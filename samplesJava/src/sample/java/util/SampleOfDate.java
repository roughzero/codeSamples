/*
 * Created on 2017年10月26日
 */
package sample.java.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SampleOfDate {
    public static void main(String[] args) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(format.parse(format.format(new Date())));
    }
}
