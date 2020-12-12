package com.xjj.java.zhan;

import org.junit.Test;

import java.util.HashMap;

/**
 *
 * 栈的运行流程
 */
public class TestZhan {

    @Test
    public void main(){
        new HashMap<>();
            test1();
           System.out.println("main 结束。。。。");
    }

    private static void test1() {
        int x = 10;
        int y = 10;
        int result = test2(10, 10);
        System.out.printf("结果:"+result);

    }

    private static int test2(int x,int y) {
        return x*y;
    }
}
