package com.xjj.java.mianshi;

/**
 * https://blog.csdn.net/qq_52467117/article/details/122508481
 * ֵ���ݺ����ô���(javaֻ��ֵ����)
 * ֵ���ݣ������ڷ������õ�ʱ��ʵ���ǽ��Լ���һ�ݿ��������βΣ��ڷ����ڣ��Ըò���ֵ���޸Ĳ�Ӱ��ԭ����ʵ�Ρ�
 * ���ô��ݣ����ڷ������õ�ʱ��ʵ�ν��Լ��ĵ�ַ���ݸ��βΣ���ʱ�����ڶԸò���ֵ�ĸı䣬���ǶԸ�ʵ�ε�ʵ�ʲ�����
 */
public class ValueDeliverOrObjDeliver {


    public static void main(String[] args) {

        // ������������,�����ǲ����ĸ���,������������
        int a = 1;
        int b = 2;
        swap(a,b);
        System.out.println(a);
        System.out.println(b);

        // ���鴫�ݵ��Ƕ�������ã�ֵ�ǻᷢ���ı��
        // ���﷽��array�Ƕ��������arr�Ŀ����������Ƕ�����Ŀ�������ˣ� array �� arr ָ�����ͬһ���������
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println("����=========>"+arr[0]);
        change(arr);
        System.out.println("����=========>"+arr[0]);


    }

    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }


    public static void change(int[] array) {
        // ������ĵ�һ��Ԫ�ر�Ϊ0
        array[0] = 0;
    }


}
