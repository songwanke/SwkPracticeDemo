package com.swk.common.enums;

/**
 * @author songwanke
 * @date 2017/11/16
 */
public class Singleton1 {
    private static Singleton1 singleton = null;

    private Singleton1() {

    }

    /**
     * 线程不安全
     * 饱汉模式的核心就是懒加载。
     * 好处是更启动速度快、节省资源，一直到实例被第一次访问，才需要初始化单例；
     * 小坏处是写起来麻烦，大坏处是线程不安全，if语句存在竞态条件。
     *
     * @return
     */
    public static Singleton1 getInstance() {
        if (singleton == null) {
            singleton = new Singleton1();
        }
        return singleton;
    }
}
