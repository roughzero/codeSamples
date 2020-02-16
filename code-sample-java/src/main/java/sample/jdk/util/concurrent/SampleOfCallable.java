/*
 * Created on 2019年12月22日
 */
package sample.jdk.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SampleOfCallable implements Callable<Boolean> {
    private static Log logger = LogFactory.getLog(SampleOfCallable.class);

    @Override
    public Boolean call() throws Exception {
        Thread.sleep(2000);
        return true;
    }

    public static void main(String[] args) {
        final ExecutorService service = Executors.newSingleThreadExecutor();
        Future<Boolean> future = service.submit(new SampleOfCallable());
        Boolean result;

        long start = System.currentTimeMillis();
        try {
            result = future.get(1000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            logger.error("Time out.");
            result = false;
        } catch (InterruptedException | ExecutionException e) {
            logger.error(e, e);
            result = false;
        } finally {
            service.shutdown();
        }
        long end = System.currentTimeMillis();
        logger.info("Result = " + result + ", cost: " + (end - start));
    }
}
