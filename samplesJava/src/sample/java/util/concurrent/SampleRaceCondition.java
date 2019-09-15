/*
 * Created on 2014年5月14日
 */
package sample.java.util.concurrent;

public class SampleRaceCondition {
    private static volatile boolean done = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {

            @SuppressWarnings("unused")
            @Override
            public void run() {
                int i = 0;
                while (!done) {
                    i++;
                }
                System.out.println("Done!");
            }
        }).start();

        System.out.println("OS: " + System.getProperty("os.name"));
        Thread.sleep(2000);
        done = true;
        System.out.println("flag done set to true");
    }
}
