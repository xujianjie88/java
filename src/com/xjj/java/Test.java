package com.xjj.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Test {

//    public Integer num = 10;

    public Boolean getIsDegrade() {
        return isDegrade;
    }

    public void setIsDegrade(Boolean degrade) {
        isDegrade = degrade;
    }

    private Boolean isDegrade;

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,2,4);
        Test test = new Test();
        for(int i=0;i<100;i++){
            new Thread(()->{
                test.A();
            }).start();
        }
    }

    public void A(){
        Integer num = 10;
        num++;
        System.out.println(Thread.currentThread().getName()+":"+num);
        num--;
        System.out.println(Thread.currentThread().getName()+":"+num);
    }
}
