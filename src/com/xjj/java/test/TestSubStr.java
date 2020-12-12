package com.xjj.java.test;

/**
 * @description:
 * @author: xujianjie
 * @create: 2020-08-14 12:48
 **/
public class TestSubStr {

    private String num;

    public static void main(String[] args) {
        String chineseStr = "GB 2760-2014 食品安全国家标准 食品添加剂使用标准";
        String charStr = "GB 2760-2014 食品安全国家标准 食品添加剂使用标准";
        chineseStr = chineseStr.replaceAll("[^\u4e00-\u9fa5]", "");
        System.out.println(chineseStr);
        String num= chineseStr.substring(0,1);
        String b = charStr.substring(0, charStr.indexOf(num)).trim();
        b = b.replaceAll(" ","/");
        System.out.println(b);
    }
}

