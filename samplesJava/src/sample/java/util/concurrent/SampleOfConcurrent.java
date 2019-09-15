/*
 * Created on 2015年12月17日
 */
package sample.java.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class SampleOfConcurrent {
    public static void main(String[] args) {
        final ExecutorService service = Executors.newSingleThreadExecutor();
        Boolean result;
        Future<Boolean> future = service.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                try {
                    Thread.sleep(2000);
                    return true;
                } finally {
                    System.out.println("Shut down ExecutorService.");
                    service.shutdownNow();
                }
            }
        });
        long start = System.currentTimeMillis();
        try {
            result = future.get(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            result = false;
        } catch (ExecutionException e) {
            e.printStackTrace();
            result = false;
        } catch (TimeoutException e) {
            System.out.println("Time out.");
            result = false;
        }
        long end = System.currentTimeMillis();
        System.out.println("Result = " + result + ", cost: " + (end - start));
    }
}
