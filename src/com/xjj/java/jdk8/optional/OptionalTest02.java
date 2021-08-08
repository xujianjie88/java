package com.xjj.java.jdk8.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-08-08 09:56
 **/
public class OptionalTest02 {

    public static void main(String[] args) {

        //案例1：
        User user = null;
        Optional.ofNullable(user).ifPresent(u-> System.out.println(u.getUsername()));

        //案例2：Optional map(将用户名转为大写)
        User user1 = new User("xujianjie");
        String nameToUpperCase = Optional.ofNullable(user1).map(User::getUsername).map(String::toUpperCase).orElse(null);
        System.out.println(nameToUpperCase);

        //案例3:filter
        User user2 = new User("xujianjie");
        user2 = Optional.ofNullable(user2).filter(u -> u.getUsername().length() > 9).orElse(null);
        System.out.println(user2);

    }

}
