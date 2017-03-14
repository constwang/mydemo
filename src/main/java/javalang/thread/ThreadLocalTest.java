package javalang.thread;

/**
 * Created by wa on 2017/3/14.
 */
public class ThreadLocalTest extends Thread {
    private ThreadLocal local = new ThreadLocal();

    @Override
    public void run() {
        //
        local.set(Math.random() * 100D);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(local.get());
    }

    public static void main(String[] args) {
        Integer num = 5;
        Integer num2 = 5;
        System.out.println(num == num2);
        ThreadLocalTest threadLocal = new ThreadLocalTest();
        Thread thread1 = new Thread(threadLocal);
        Thread thread2 = new Thread(threadLocal);
        thread1.start();
        thread2.start();
    }
}
