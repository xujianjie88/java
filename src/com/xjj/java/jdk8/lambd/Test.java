package com.xjj.java.jdk8.lambd;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-07-18 16:26
 **/
public class Test {

    public static void main(String[] args) {
        //默认实现方式
        getOrderDetail(new OrderService() {
            @Override
            public void getOrderDetail() {
                System.out.println("获取订单详情。。。");
            }
        });
        //lambda实现方式无参无返回值
        getOrderDetail(()->{
            System.out.println("lambda------>获取订单详情");
        });
    }

    public static void getOrderDetail(OrderService orderService){
        orderService.getOrderDetail();
    }


}
