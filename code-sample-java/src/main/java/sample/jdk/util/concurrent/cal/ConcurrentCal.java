/*
 * Created on 2014年5月16日
 */
package sample.jdk.util.concurrent.cal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ConcurrentCal implements Callable<CalDto> {

    private CalDto dto;

    public CalDto getDto() {
        return dto;
    }

    public void setDto(CalDto dto) {
        this.dto = dto;
    }

    @Override
    public CalDto call() throws Exception {
        dto.setResult(100 - dto.getCondition());
        Thread.sleep(100);
        return dto;
    }

    public static void main(String[] args) throws Exception {
        List<ConcurrentCal> calList = new ArrayList<ConcurrentCal>();
        for (int i = 0; i < 100; i++) {
            ConcurrentCal cal = new ConcurrentCal();
            CalDto dto = new CalDto();
            dto.setCondition(i);
            cal.setDto(dto);
            calList.add(cal);
        }

        ExecutorService executorPool = Executors.newFixedThreadPool(4);

        long current = System.currentTimeMillis();
        System.out.println("Start test.....");
        List<Future<CalDto>> results = executorPool.invokeAll(calList, 10000, TimeUnit.SECONDS);
        System.out.println("End test, cost " + (System.currentTimeMillis() - current));

        for (Future<CalDto> future : results) {
            CalDto dto = future.get();
            System.out.println("Conditon: " + dto.getCondition() + ", result: " + dto.getResult());
        }

        executorPool.shutdown();
    }

}
