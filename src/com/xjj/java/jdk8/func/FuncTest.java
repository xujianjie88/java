package com.xjj.java.jdk8.func;

import com.xjj.java.oom.HeadOOM;

public class FuncTest {

    public static void main(String[] args) {
        System.out.println(testFunc(()->new FuncTest()));
    }

    public static <T> T testFunc(FunctionalService<T> functionalService){
        return functionalService.fucn1();
    }

}
