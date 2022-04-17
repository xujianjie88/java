package com.xjj.java.designpattern.prototype.deepclone;

/**
 * @description:
 * @author: xujianjie
 * @create: 2020-07-19 15:03
 **/
public class Client {

    public static void main(String[] args) throws Exception {
        DeepPrototype deepPrototype = new DeepPrototype();
        deepPrototype.name = "�ν�";
        deepPrototype.deepCloneTarget = new DeepCloneTarget("��ţ","��ţ����");

//        // ��ʽһ������
//        DeepPrototype deepPrototype2 = (DeepPrototype) deepPrototype.clone();
//        System.out.println("deepPrototype.name"+deepPrototype.name+"deepPrototype.deepCloneTarget="+deepPrototype.deepCloneTarget.hashCode());
//        System.out.println("deepPrototype2.name"+deepPrototype2.name+"deepPrototype2.deepCloneTarget="+deepPrototype2.deepCloneTarget.hashCode());

        // ��ʽ�����������л�������
        // ��ʽһ������
        DeepPrototype deepPrototype2 = (DeepPrototype) deepPrototype.clone();
        System.out.println("deepPrototype.name"+deepPrototype.name+"deepPrototype.deepCloneTarget="+deepPrototype.deepCloneTarget.hashCode());
        System.out.println("deepPrototype2.name"+deepPrototype2.name+"deepPrototype2.deepCloneTarget="+deepPrototype2.deepCloneTarget.hashCode());


    }

}
