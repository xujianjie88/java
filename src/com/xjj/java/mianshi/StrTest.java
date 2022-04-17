package com.xjj.java.mianshi;

public class StrTest {

    public static void main(String[] args) {
        String str = "adadavvffggggr";
        System.out.println(strDistinct(str));
    }

    public static String strDistinct(String str) {
        StringBuffer resStr = new StringBuffer();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                continue;
            }else {
                resStr.append(chars[i]);
            }
        }
        return resStr.toString();
    }

}

