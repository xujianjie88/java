package com.xjj.java.designpattern.teamplate;

import lombok.Data;

import java.util.List;

@Data
public class MyContext {

    private String name;
    private String desc;

    List<String> selectSql;

}
