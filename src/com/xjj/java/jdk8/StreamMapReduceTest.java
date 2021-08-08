package com.xjj.java.jdk8;

import com.xjj.java.reflect.Person;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-07-25 16:33
 **/
public class StreamMapReduceTest {

    static class Person{
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }


    public static void main(String[] args) {

       //���������ܺ�
        Optional<Integer> reduce = Stream.of(
                new Person("����", 14),
                new Person("����", 15),
                new Person("����", 16)
        ).map(Person::getAge)
//                .reduce((x, y) -> x + y);
//        .reduce(Integer::sum);//���
        .reduce(Math::max);//�����ֵ
        System.out.println(reduce.get());
    }

}
