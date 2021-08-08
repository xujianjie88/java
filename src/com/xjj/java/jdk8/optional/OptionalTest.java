package com.xjj.java.jdk8.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-08-01 19:28
 **/
public class OptionalTest {

    public static void main(String[] args) {

        User user = new User();
        user.setUsername("xujianjie");
        Car car = new Car();
        car.setCarName("奔驰");
        user.setCar(car);



//        User user1 = null;
        //如果存在打印
        Optional.ofNullable(user).ifPresent(u->System.out.println(user.getUsername()));
        //过滤姓名等于xujianjie
        Optional.ofNullable(user)
                .filter(u -> Objects.equals(u.getUsername(), "xujianjie"))
                .ifPresent(u-> System.out.println(u.getUsername()));

        List<User> userList = new ArrayList<>();
        userList = null;
//        userList.add(new User("xujianjie"));
//        userList.add(new User("xuhaoren"));

        Optional.ofNullable(userList).orElse(new ArrayList<>()).forEach(u -> {
                    System.out.println(u.getUsername());
        });
    }

}
