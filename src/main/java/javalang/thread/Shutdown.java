package javalang.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by wa on 2017/3/14.
 */
public class Shutdown {
    static class Runner implements Runnable {
        private long i;
        private volatile boolean isOn = true;

        @Override
        public void run() {
            while (isOn && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Count i = " + i);
        }

        public void cancel() {
            isOn = false;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread countThread = new Thread(new Runner());
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();

    }
}
