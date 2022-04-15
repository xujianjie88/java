package com.xjj.java.dynamicproxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

public class CglibProxyTest {
    public static void main(String[] args) {
        // //��ָ��Ŀ¼�����ɶ�̬������
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:\\class");
        // ����Enhancer����������JDK��̬�����Proxy�࣬��һ���������ü�������
        Enhancer enhancer = new Enhancer();
        // ����Ŀ������ֽ����ļ�
        enhancer.setSuperclass(CaptainAmerica2MovieImpl.class);
        // ���ûص�����
        enhancer.setCallback(new CglibProxyInterceptor());
        // �����creat����������ʽ����������
        CaptainAmerica2MovieImpl captainAmerica2Movie = (CaptainAmerica2MovieImpl)enhancer.create();
        // ���ô������play����
        captainAmerica2Movie.play();
        System.out.println("cglib��̬���������ӳ�2����"+captainAmerica2Movie.getClass());
    }
}
