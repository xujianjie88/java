package com.xjj.java.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms ���ó�ʼ���ڴ��С
 * -Xmx �����������ڴ�
 * ����ָ�-Xms128m -Xmx128m -XX:+PrintGCDetails ��ӡGC������Ϣ
 * -XX:+HeadDumpOnOutOfMemoryError ����:��ջ��Ϣ��dump�ļ�
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
