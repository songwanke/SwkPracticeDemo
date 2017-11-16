package com.swk.common.enums;

/**
 * @author songwanke
 * @date 2017/11/16
 */
public class Singleton3 {
    /**
     * 我们既希望利用饿汉模式中静态变量的方便和线程安全；又希望通过懒加载规避资源浪费。
     * Holder模式满足了这两点要求：核心仍然是静态变量，足够方便和线程安全；
     * 通过静态的Holder类持有真正实例，间接实现了懒加载。
     * 相对于饿汉模式，Holder模式仅增加了一个静态内部类的成本
     */
    private static class SingletonHolder{
        private static final Singleton3 singleton = new Singleton3();
        private SingletonHolder(){}
    }

    private Singleton3(){}
    public synchronized static Singleton3 getInstance(){
        return SingletonHolder.singleton;
    }
}
