package com.xjj.java.dynamicproxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

public class CglibProxyTest {
    public static void main(String[] args) {
        // //在指定目录下生成动态代理类
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:\\class");
        // 创建Enhancer对象，类似于JDK动态代理的Proxy类，下一步就是设置几个参数
        Enhancer enhancer = new Enhancer();
        // 设置目标类的字节码文件
        enhancer.setSuperclass(CaptainAmerica2MovieImpl.class);
        // 设置回调函数
        enhancer.setCallback(new CglibProxyInterceptor());
        // 这里的creat方法就是正式创建代理类
        CaptainAmerica2MovieImpl captainAmerica2Movie = (CaptainAmerica2MovieImpl)enhancer.create();
        // 调用代理类的play方法
        captainAmerica2Movie.play();
        System.out.println("cglib动态代理《美国队长2》："+captainAmerica2Movie.getClass());
    }
}
