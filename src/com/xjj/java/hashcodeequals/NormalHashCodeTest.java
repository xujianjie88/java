package com.xjj.java.hashcodeequals;

import java.util.*;
import java.lang.Comparable;

/**
 * @desc
 * equals() 的作用是用来判断两个对象是否相等。
 *
 * hashCode() 的作用是获取哈希码，也称为散列码；它实际上是返回一个int整数。这个哈希码的作用是确定该对象在哈希表中的索引位置。
 *
 * 原则（结论）
 *
 * 1.同一个对象（没有发生过修改）无论何时调用hashCode()得到的返回值必须一样。
 * 如果一个key对象在put的时候调用hashCode()决定了存放的位置，而在get的时候调用hashCode()得到了不一样的返回值，
 * 这个值映射到了一个和原来不一样的地方，那么肯定就找不到原来那个键值对了。
 *
 * 2.hashCode()的返回值相等的对象不一定相等，通过hashCode()和equals()必须能唯一确定一个对象。
 * 不相等的对象的hashCode()的结果可以相等。hashCode()在注意关注碰撞问题的时候，也要关注生成速度问题，完美hash不现实。
 *
 * 3.一旦重写了equals()函数（重写equals的时候还要注意要满足自反性、对称性、传递性、一致性），就必须重写hashCode()函数。
 * 而且hashCode()的生成哈希值的依据应该是equals()中用来比较是否相等的字段。
 *
 * 如果两个由equals()规定相等的对象生成的hashCode不等，对于hashMap来说，他们很可能分别映射到不同位置，
 * 没有调用equals()比较是否相等的机会，两个实际上相等
 *
 */
public class NormalHashCodeTest{


    /**
     * 1、不会创建“类对应的散列表”
     *
     * 这里所说的“不会创建类对应的散列表”是说：我们不会在HashSet, Hashtable, HashMap等等这些本质是散列表的数据结构中，用到该类。
     * 例如，不会创建该类的HashSet集合。
     *
     * 在这种情况下，该类的“hashCode() 和 equals() ”没有半毛钱关系的！
     * equals() 用来比较该类的两个对象是否相等。
     * 而hashCode() 则根本没有任何作用。
     * @param args
     */
    public static void main(String[] args) {
        // 新建2个相同内容的Person对象，
        // 再用equals比较它们是否相等
        Person p1 = new Person("eee", 100);
        Person p2 = new Person("eee", 100);
        Person p3 = new Person("aaa", 200);
        System.out.printf("p1.equals(p2) : %s; p1(%d) p2(%d)\n", p1.equals(p2), p1.hashCode(), p2.hashCode());
        System.out.printf("p1.equals(p3) : %s; p1(%d) p3(%d)\n", p1.equals(p3), p1.hashCode(), p3.hashCode());
    }

    /**
     * @desc Person类。
     */
    private static class Person {
        int age;
        String name;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return name + " - " +age;
        }

        /**
         * @desc 覆盖equals方法
         */
        public boolean equals(Object obj){
            if(obj == null){
                return false;
            }

            //如果是同一个对象返回true，反之返回false
            if(this == obj){
                return true;
            }

            //判断是否类型相同
            if(this.getClass() != obj.getClass()){
                return false;
            }

            Person person = (Person)obj;
            return name.equals(person.name) && age==person.age;
        }
    }
}
