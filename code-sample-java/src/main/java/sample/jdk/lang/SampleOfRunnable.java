/*
 * Created on 2019年12月22日
 */
package sample.jdk.lang;

public class SampleOfRunnable implements Runnable {

    @Override
    public void run() {
        // 线程中处理的内容
    }

    public static void main(String[] args) {
        Runnable runnable = new SampleOfRunnable();
        Thread[] threads = {new Thread(runnable), new Thread(runnable)};
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
