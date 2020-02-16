/*
 * Created on 2014年5月19日
 */
package sample.jdk.util.concurrent.cal;

public class SequentialPrimeFinder extends AbstractPrimeFinder {

    @Override
    public int countPrimes(int number) {
        return countPrimeInRange(1, number);
    }

    public static void main(String[] args) {
        new SequentialPrimeFinder().timeAndCompute(10000000);
    }
}
