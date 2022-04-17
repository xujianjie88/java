package com.xjj.java.classloader;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义类加载器
 */
public class MyClassLoader extends ClassLoader {

    private String name;

    public MyClassLoader(ClassLoader parent,String name) {
        super(parent);
        this.name = name;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String filePath = "D:\\test.class";
        byte[] data = new byte[0];
        try {
            data = getBytes(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.defineClass(name,data,0,data.length);
        return super.findClass(name);
    }

    private byte[] getBytes(String filePath) throws IOException {
        InputStream is = new FileInputStream(filePath);
        BufferedInputStream bis = new BufferedInputStream(is);
        byte[] bs = null;
        try {
            int length = is.available();
            bs = new byte[length];
            System.err.println("ddd:" + bs.length);
            bis.read(bs);
            return bs;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bis.close();
        }
        return bs;
    }

//    //这里实现自己的加载逻辑
//    @Override
//    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
//        //....打破双亲委派,执行自己定义的逻辑 (注意)
//        return findClass(name);
//    }


    @Override
    public String toString() {
        return "MyClassLoader{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        MyClassLoader classLoader = new MyClassLoader(MyClassLoader.class.getClassLoader(), "MyClassLoader");
        try {
            Class c = classLoader.loadClass("com.xjj.java.classloader.Test");
            System.out.println(c.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
