package com.xjj.java.mianshi;

import java.io.*;

public class TestFileInputStream extends MyClassLoader{

    public class MyClassLoader extends ClassLoader {

        // 此类加载器加载的路径
        private String root;

        public MyClassLoader(ClassLoader parent, String root) {
            super(parent);
            this.root = root;
        }

        public MyClassLoader(String root) {
            this.root = root;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            // IO流读取字节码文件为二进制流
            try (BufferedInputStream bis = new BufferedInputStream((new FileInputStream(root + name + ".class")));
                 ByteArrayOutputStream bos = new ByteArrayOutputStream()) {

                int len;
                byte[] bytes = new byte[1024];
                // 每次读取1024个字节,应该要一直读取,一直到-1时才停止读取
                while ((len = bis.read(bytes)) != -1) {
                    bos.write(bytes, 0, len);
                }
                bos.flush();
                bytes = bos.toByteArray();
                return defineClass(null,bytes,0,bytes.length);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
