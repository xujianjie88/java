package com.xjj.java.mianshi;

/**
 * https://blog.csdn.net/qq_52467117/article/details/122508481
 * 值传递和引用传递(java只有值传递)
 * 值传递：就是在方法调用的时候，实参是将自己的一份拷贝赋给形参，在方法内，对该参数值的修改不影响原来的实参。
 * 引用传递：是在方法调用的时候，实参将自己的地址传递给形参，此时方法内对该参数值的改变，就是对该实参的实际操作。
 */
public class ValueDeliverOrObjDeliver {


    public static void main(String[] args) {

        // 基本数据类型,传的是参数的副本,交换后结果不变
        int a = 1;
        int b = 2;
        swap(a,b);
        System.out.println(a);
        System.out.println(b);

        // 数组传递的是对象的引用，值是会发生改变的
        // 这里方法array是对象的引用arr的拷贝，而不是对象本身的拷贝，因此， array 和 arr 指向的是同一个数组对象
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println("数组=========>"+arr[0]);
        change(arr);
        System.out.println("数组=========>"+arr[0]);


    }

    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }


    public static void change(int[] array) {
        // 将数组的第一个元素变为0
        array[0] = 0;
    }


}
