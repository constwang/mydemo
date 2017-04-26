package javalang.thread;

/**
 * Created by wa on 2017/4/25.
 */
public class WaitAndNotify {
    public static void main(String[] args) {
        String lock = "lock";
        try {
            lock.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
