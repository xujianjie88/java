package com.xjj.java.mianshi;

public class TestDigui {

    public static void main(String[] args) {
        System.out.println(digui(5));
    }

    private static int digui(int i) {
        if(i<=2){
            return i;
        }
        return digui(i-1)+digui(i-2);
    }
}
