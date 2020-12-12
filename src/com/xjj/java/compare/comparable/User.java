package com.xjj.java.compare.comparable;

/**
 * @description:Comparable和compareTo
 * @author: xujianjie
 * @create: 2020-12-12 10:05
 **/
public class User implements Comparable<User>{

    private Integer userId;

    private String userName;

    @Override
    public int compareTo(User user) {
        //降序(当你使用一个外来对象的属性减-本对象的属性时)
        return user.userId - this.userId;
//        //升序
//        return this.userId - user.userId;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
