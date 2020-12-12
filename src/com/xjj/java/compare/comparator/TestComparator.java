package com.xjj.java.compare.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @description:
 * @author: xujianjie
 * @create: 2020-12-12 10:31
 **/
public class TestComparator {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student student = new Student(12,"哈哈");
        students.add(student);
        student = new Student(18,"咳咳");
        students.add(student);
        student = new Student(8,"嗯嗯");
        students.add(student);
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                //如果前者的学号大于后者的学号，就是前者大于后者，返回1系统就会识别是前者大于后者
                if (s1.getStu_id() > s2.getStu_id()) {
                    return 1;
                }
                //小于同理
                if (s1.getStu_id() < s2.getStu_id()) {
                    return -1;
                }
                //如果返回0则认为前者与后者相等
                return 0;
            }
        });
        System.out.println(students);
    }

}
