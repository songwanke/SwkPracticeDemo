package com.swk.common.enums;

/**
 * @author songwanke
 * @date 2017/11/16
 */
public class Singleton2 {
    public static final Singleton2 singleton = new Singleton2();

    private Singleton2() {
    }

    /**
     * 饿汉的好处是天生的线程安全（得益于类加载机制），写起来超级简单，使用时没有延迟；
     * 坏处是有可能造成资源浪费（如果类加载后就一直不使用单例的话）。
     * @return
     */
    public static Singleton2 getInstance() {
        return singleton;
    }
}
