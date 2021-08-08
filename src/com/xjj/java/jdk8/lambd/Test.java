package com.xjj.java.jdk8.lambd;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-07-18 16:26
 **/
public class Test {

    public static void main(String[] args) {
        //Ĭ��ʵ�ַ�ʽ
        getOrderDetail(new OrderService() {
            @Override
            public void getOrderDetail() {
                System.out.println("��ȡ�������顣����");
            }
        });
        //lambdaʵ�ַ�ʽ�޲��޷���ֵ
        getOrderDetail(()->{
            System.out.println("lambda------>��ȡ��������");
        });
    }

    public static void getOrderDetail(OrderService orderService){
        orderService.getOrderDetail();
    }


}
