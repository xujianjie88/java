package com.xjj.java.designpattern.prototype.deepclone;


import java.io.*;

/**
 * @description:
 * @author: xujianjie
 * @create: 2020-07-19 14:56
 **/
public class DeepPrototype implements Serializable,Cloneable {

    public String name;

    public DeepCloneTarget deepCloneTarget;

    public DeepPrototype() {
    }

    //深拷贝，方式一，使用clone方法

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object object = null;
        //这里完成对基本数据类型和String的克隆
        object = super.clone();
        //对引用类型单独处理
        DeepPrototype deepPrototype = (DeepPrototype) object;
        deepPrototype.deepCloneTarget = (DeepCloneTarget) deepCloneTarget.clone();
        return object;
    }

    //方式二，对象序列化的方式（推荐使用）
    public Object deepClone() {
        //创建对象
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            DeepPrototype deepPrototype = (DeepPrototype) ois.readObject();
            return deepPrototype;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            try {
                bis.close();
                ois.close();
                oos.close();
                bos.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
