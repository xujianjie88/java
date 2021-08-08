package com.xjj.java.jdk8.optional;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-08-01 19:22
 **/
public class User {

    private String username;
    private Car Car;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public com.xjj.java.jdk8.optional.Car getCar() {
        return Car;
    }

    public void setCar(com.xjj.java.jdk8.optional.Car car) {
        Car = car;
    }

    public User(String username) {
        this.username = username;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", Car=" + Car +
                '}';
    }
}
