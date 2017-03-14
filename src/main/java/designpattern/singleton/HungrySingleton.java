package designpattern.singleton;

/**
 * Created by wa on 2017/3/14.
 * 饿汉单利模式
 */
public class HungrySingleton {
    private HungrySingleton() {
    }

    //private static final HungrySingleton instance=new HungrySingleton();

    private static final HungrySingleton instance;

    static {
        instance = new HungrySingleton();
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
