package sample.jdk.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SampleOfList {
    public static void main(String[] args) {
        List<Integer> testList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            testList.add(i);
        }
        testList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(testList);

        List<Integer> subList = testList.subList(0, 1);
        System.out.println(subList.size());
    }
}
