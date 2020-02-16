/*
 * Created on 2019年12月22日
 */
package sample.jdk.lang;

public class SampleOfThread extends Thread {

    @Override
    public void run() {
        super.run();
        // 线程中处理的内容
    }

    public static void main(String[] args) {
        SampleOfThread[] threads = { new SampleOfThread(), new SampleOfThread() };
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
