package javalang.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * Created by wa on 2017/4/5.
 */
public class RecipesNoLock {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + System.currentTimeMillis());
            }).start();
            latch.countDown();
        }
    }
}
