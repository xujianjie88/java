package com.xjj.java.compare.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: xujianjie
 * @create: 2020-12-12 10:09
 **/
public class TestComparable {

    public static void main(String[] args) {
        //默认是根据id排序
        List<User> users = new ArrayList<>();
        User user = new User(2,"aa");
        users.add(user);
        user = new User(1,"bb");
        users.add(user);
        user = new User(3,"cc");
        users.add(user);
        Collections.sort(users);
        System.out.println(users);
    }

}
