package com.xjj.java.singleIton;

/**
 *
 * 懒汉模式的懒体现在类加载的时候并没有立刻实例化，等到调用getInstance的时候，才真的实例化。
 * 如果整个代码都没有调用getInstance，那么实例化的过程就被省略了。
 *
 */
public class LazySingleton {

    private LazySingleton() {
    }
    private static LazySingleton instance = null;
    public static LazySingleton getInstance() {
        if(instance==null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
