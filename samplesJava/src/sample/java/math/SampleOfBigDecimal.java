/*
 * Created on 2015年11月30日
 */
package sample.java.math;

import java.math.BigDecimal;

public class SampleOfBigDecimal {
    public static void main(String[] args) {
        System.out.println(new BigDecimal("1,594,456".replaceAll(",", "")));
        System.out.println(new BigDecimal("1.0"));
        System.out.println(660342.82 + 198792.21);
        System.out.println(660342.02 + 198793.01);
        BigDecimal a = new BigDecimal("660342.82");
        BigDecimal b = new BigDecimal("198792.21");
        System.out.println(a.add(b));

        double base = 208771.1;

        double rateBase1 = Math.pow(1.06d, 1d / 365);
        double rateBase2 = Math.pow(1.052d, 1d / 365);
        rateBase1 = round(rateBase1, 8);
        rateBase2 = round(rateBase2, 8);

        double rate1 = rateBase1 * rateBase2 * rateBase2;
        double rate2 = rateBase1 * rateBase2 * rateBase2 * rateBase2;

        System.out.println(base * rate1);
        System.out.println(base * rate2);
        System.out.println(base * rate2 - base * rate1);

        rate1 = round(rate1, 8);
        rate2 = round(rate2, 8);
        System.out.println(base * rate1);
        System.out.println(base * rate2);
        System.out.println(base * rate2 - base * rate1);
    }

    private static double round(double value, int scale) {
        return new BigDecimal(value).setScale(8, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
