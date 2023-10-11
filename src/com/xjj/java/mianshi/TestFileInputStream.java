package com.xjj.java.mianshi;

import java.io.*;

public class TestFileInputStream extends MyClassLoader{

    public class MyClassLoader extends ClassLoader {

        // ������������ص�·��
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
            // IO����ȡ�ֽ����ļ�Ϊ��������
            try (BufferedInputStream bis = new BufferedInputStream((new FileInputStream(root + name + ".class")));
                 ByteArrayOutputStream bos = new ByteArrayOutputStream()) {

                int len;
                byte[] bytes = new byte[1024];
                // ÿ�ζ�ȡ1024���ֽ�,Ӧ��Ҫһֱ��ȡ,һֱ��-1ʱ��ֹͣ��ȡ
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
