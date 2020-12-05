package sample.jdk.util;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 遍历匹配示例
 * 测试使用循环与哈希算法匹配的效率差异以及列表条数对时间的影响
 */
@CommonsLog
public class SampleOfTraverse {
    private static final int LOOP_SIZE = 100000;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < LOOP_SIZE; i++) {
            list.add(i);
        }

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < LOOP_SIZE; i++) {
            list.contains(i);
        }
        stopWatch.stop();
        log.info("Traverse by list finished, cost: " + stopWatch.getNanoTime());

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < LOOP_SIZE; i++) {
            set.add(i);
        }

        stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < LOOP_SIZE; i++) {
            set.contains(i);
        }
        stopWatch.stop();
        log.info("Traverse by map finished, cost: " + stopWatch.getNanoTime());
    }
}
