package com.xjj.java.annotation;

public class User {
    /*
     * @Description 描述一只猫吃鱼的方法
     * @Date 2020/6/6
     * @Param []
     * @return void
     */
    @Check(login = false)
    public void findUserInfo(Integer userId) {
        System.out.println("查询用户的信息:"+userId);
    }
}
