/*
 * Created on 2013-9-11
 */
package sample.java.text;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SampleFormat {
    public static void main(String[] args) {
        double d = 111234567890.12;
        NumberFormat format = new DecimalFormat(".##");
        System.out.println(format.format(d));
        System.out.println((100 % 1000));
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println(timeFormat.format(new Date()));
    }
}
