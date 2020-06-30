package com.xjj.java.singleIton;

/**
 * 1.饿汉模式：
 * 饿汉模式的饿体现在只要类被加载，就会立即实例化Singleton实例，后续无论怎么操作，只要严格使用getInstance，就不会出现其他实例。
 */
public  class HungrySingleton {
    private HungrySingleton() {
    }

    private static HungrySingleton instance = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return instance;
    }
}
