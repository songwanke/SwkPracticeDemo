package com.swk.common.enums;

/**
 * @author songwanke
 * @date 2017/11/16
 */
public class Singleton1_2 {
    private static Singleton1_2 singleton = null;

    private Singleton1_2() {
    }

    /**
     * 双重检查锁
     * 线程不安全
     * 由于指令重排序，可能会得到“半个对象”
     * @return
     */
    public static Singleton1_2 getInstance() {
        if (singleton == null) {
            synchronized (Singleton1_2.class) {
                if (singleton == null) {
                    singleton = new Singleton1_2();
                }
            }
        }
        return singleton;
    }
}
