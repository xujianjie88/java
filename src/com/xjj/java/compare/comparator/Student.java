package com.xjj.java.compare.comparator;

import java.util.Comparator;

/**
 * @description:Comparator 和 compare
 * @author: xujianjie
 * @create: 2020-12-12 10:27
 **/
public class Student implements Comparator<Student> {

    private Integer stu_id;

    private String stu_name;

    @Override
    public int compare(Student s1, Student s2) {
        //如果前者的学号大于后者的学号，就是前者大于后者，返回1系统就会识别是前者大于后者
        if (s1.stu_id > s2.stu_id) {
            return 1;
        }
        //小于同理
        if(s1.stu_id < s2.stu_id){
            return -1;
        }
        //如果返回0则认为前者与后者相等
        return 0;
    }

    public Integer getStu_id() {
        return stu_id;
    }

    public void setStu_id(Integer stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public Student(Integer stu_id, String stu_name) {
        this.stu_id = stu_id;
        this.stu_name = stu_name;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_id=" + stu_id +
                ", stu_name='" + stu_name + '\'' +
                '}';
    }
}
