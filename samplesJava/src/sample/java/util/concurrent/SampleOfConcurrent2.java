/*
 * Created on 2015年12月17日
 */
package sample.java.util.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SampleOfConcurrent2 {

    public static void main(String[] args) throws InterruptedException {
        long start = System.nanoTime();
        // 必须使用 final, 否则会报错
        final ExecutorService service = Executors.newSingleThreadExecutor();

        service.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("Test");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Shut down ExecutorService.");
                    service.shutdown(); // 在这里关闭
                }
            }
        });
        long end = System.nanoTime();
        System.out.println("cost: " + (end - start));
    }
}
