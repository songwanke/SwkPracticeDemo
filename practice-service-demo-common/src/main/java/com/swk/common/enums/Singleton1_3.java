package com.swk.common.enums;

/**
 * @author songwanke
 * @date 2017/11/16
 */
public class Singleton1_3 {
    private static volatile Singleton1_3 singleton = null;

    private Singleton1_3() {

    }

    public static Singleton1_3 getInstance() {
        if (singleton == null) {
            synchronized (Singleton1_3.class) {
                if (singleton == null) {
                    singleton = new Singleton1_3();
                }
            }
        }
        return singleton;
    }
}
