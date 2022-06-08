package com.xjj.java.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms 设置初始化内存大小
 * -Xmx 设置最大分配内存
 * 调优指令：-Xms128m -Xmx128m -XX:+PrintGCDetails 打印GC回收信息
 * -XX:+HeadDumpOnOutOfMemoryError 分析:堆栈信息的dump文件
 * <p>
 * vm option:-Xms8m -Xms8m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeadOOM {

//    byte[] bytes = new byte[1 * 1024 * 1024];//1m

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        while (true) {
            list.add(new HeadOOM());
        }
    }
}
