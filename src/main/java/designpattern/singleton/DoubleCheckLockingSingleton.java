package designpattern.singleton;

/**
 * Created by wa on 2017/3/14.
 * 双重检查锁定 实现单例模式（懒汉）
 * 1 分配对象的内存空间
 * 2 初始化对象
 * 3 设置instance 指向刚分配的内存地址
 */
public class DoubleCheckLockingSingleton {
    private static volatile DoubleCheckLockingSingleton instance;

    private DoubleCheckLockingSingleton() {
    }

    public static DoubleCheckLockingSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLockingSingleton.class) {
                instance = new DoubleCheckLockingSingleton();
            }
        }
        return instance;
    }
}
