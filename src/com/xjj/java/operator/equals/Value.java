package com.xjj.java.operator.equals;

/**
 * @description:
 * @author: xujianjie
 * @create: 2020-07-05 14:52
 **/
class Value {
    int i;
}

class EqualsMethod2 {
    public static void main(String[] args) {
        Value v1 = new Value();
        Value v2 = new Value();
        v1.i = v2.i = 100;
        // equals() 的默认行为是比较对象的引用而非具体内容。
        // 因此，除非你在新类中覆写 equals() 方法，否则我们将获取不到想要的结果。
        System.out.println(v1.equals(v2));//false
    }
}
