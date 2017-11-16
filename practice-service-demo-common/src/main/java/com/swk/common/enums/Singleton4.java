package com.swk.common.enums;

/**
 * @author songwanke
 * @date 2017/11/16
 */
public enum Singleton4 {
    /**
     * 代码量比饿汉模式更少。
     * 但用户只能直接访问实例Singleton4.SINGLETON——事实上，这样的访问方式作为单例使用也是恰当的，只是牺牲了静态工厂方法的优点，如无法实现懒加载
     * 枚举型单例模式的本质
     * public class Singleton4 extends Enum<Singleton4> {
     * ...
     * public static final Singleton4 SINGLETON = new Singleton4();
     * ...
     * }
     * 本质上和饿汉模式相同，区别仅在于公有的静态成员变量。
     */
    SINGLETON;
}
