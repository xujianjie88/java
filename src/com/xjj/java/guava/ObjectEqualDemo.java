package com.xjj.java.guava;

import com.google.common.base.Objects;

/**
 * 当一个对象中的字段可以为null时，实现Object.equals方法会很痛苦，
 * 因为不得不分别对它们进行null检查。使用Objects.equal帮助你执行null敏感的equals判断，从而避免抛出
 */
public class ObjectEqualDemo {

    public static void main(String[] args) {
        System.out.println(Objects.equal("a", "a"));
        System.out.println(Objects.equal(null, "a"));
        System.out.println(Objects.equal("a", null));
        System.out.println(Objects.equal(null, null));
    }
}
