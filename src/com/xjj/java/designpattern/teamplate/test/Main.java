package com.xjj.java.designpattern.teamplate.test;

import com.xjj.java.designpattern.teamplate.DefaultBackUpHandler;
import com.xjj.java.designpattern.teamplate.IBackUpHandler;
import com.xjj.java.designpattern.teamplate.MyContext;
import com.xjj.java.designpattern.teamplate.enums.BackUpStrategyEnum;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {



    public static void main(String[] args) {

        MyContext myContext = new MyContext();
        List<String> sqlList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            sqlList.add("select * from test" + i);
        }
        myContext.setSelectSql(sqlList);

        List<String> strategyList = Arrays.asList("default", "bigdata", "default", "bigdata", "default", "bigdata", "default", "bigdata", "default");

        for (String s : strategyList) {
            IBackUpHandler iBackUpHandler = BackUpStrategyEnum.getBackUpStrategyEnumByValue(s);
            iBackUpHandler.doBackUp(new MyContext());
        }


    }
}
