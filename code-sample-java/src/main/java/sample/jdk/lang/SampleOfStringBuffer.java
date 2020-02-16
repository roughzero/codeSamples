/*
 * Created on 2014年5月5日
 */
package sample.jdk.lang;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Random;

/**
 * 测试 StringBuffer 与 String 拼接 String 的效率差.
 * 
 * @author rough
 */
public class SampleOfStringBuffer {

    private static final int TEST_COUNTS = 100000;

    protected static Log logger = LogFactory.getLog(SampleOfStringBuffer.class);

    private void testString() {
        @SuppressWarnings("unused")
        String s = "";
        Random random = new Random();
        for (int i = 0; i < TEST_COUNTS; i++) {
            s += random.nextInt(9);
        }
    }

    private void testStringBuffer() {
        StringBuffer s = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < TEST_COUNTS; i++) {
            s.append(random.nextInt(9));
        }
    }

    public static void main(String[] args) {

        SampleOfStringBuffer sample = new SampleOfStringBuffer();

        StopWatch stopWatch = new StopWatch();
        logger.info("Test of String start.");
        stopWatch.start();
        sample.testString();
        stopWatch.stop();
        logger.info("Test of String end. Cost " + stopWatch.getTime());

        stopWatch.reset();
        logger.info("Test of StringBuffer start.");
        stopWatch.start();
        sample.testStringBuffer();
        stopWatch.stop();
        logger.info("Test of StringBuffer end. Cost " + stopWatch.getTime());

        int test = (int) (1221.1 * 100);

        System.out.println(test);
    }
}
