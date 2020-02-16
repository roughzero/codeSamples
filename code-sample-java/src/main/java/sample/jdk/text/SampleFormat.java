/*
 * Created on 2013-9-11
 */
package sample.jdk.text;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SampleFormat {
    public static void main(String[] args) {
        double d = 111234567890.12;
        System.out.println(d);
        NumberFormat format = new DecimalFormat(".##");
        System.out.println(format.format(d));
        format = new DecimalFormat("##############################");
        System.out.println(format.format(d));
        System.out.println((100 % 1000));
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println(timeFormat.format(new Date()));

        format = new DecimalFormat("00000");
        System.out.println(format.format(1));

        BigDecimal id = new BigDecimal("923456789012345678901234567890");
        System.out.println(id.toString());
    }
}
