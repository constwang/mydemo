package designpattern.singleton;

/**
 * Created by wa on 2017/3/14.
 * 静态内部类实现单例模式（懒汉）
 */
public class StaticInternalClassSingleton {
    private StaticInternalClassSingleton() {
    }

    private static class InstanceHolder {
        private static final StaticInternalClassSingleton instance = new StaticInternalClassSingleton();
    }

    public static StaticInternalClassSingleton getInstance() {
        return InstanceHolder.instance;
    }
}
