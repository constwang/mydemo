package javalang.concurrent;

import java.util.concurrent.*;

/**
 * Created by wa on 2017/2/18.
 */
public class ThreadTest {
    public static void main(String[] args){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 10, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(100));



        ThreadTest threadTest=new ThreadTest();
        System.out.println(threadTest.getResult());
    }
    public boolean getResult(){
        ExecutorService executor= Executors.newFixedThreadPool(10);
        executor.execute(() -> {
            System.out.println("start");
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("test");
            }
        });
        return true;
    }
}
