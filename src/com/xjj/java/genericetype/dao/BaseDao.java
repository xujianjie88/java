package com.xjj.java.genericetype.dao;

import java.util.List;

/**
 * @description: 封装基本的增删改查
 * @author: xujianjie
 * @create: 2021-07-10 17:44
 **/
public abstract class BaseDao<T> {

    //新增
    boolean save(T o) {
        return true;
    }

    //编辑
    int update(T o){
        return 0;
    }

    //查询
    List<T> selectList(T condition){
        return null;
    }

    //删除
    void remove(T o){
    }

    //泛型方法，和传入的T没啥关系
    <E> E getValue(E e){
      return null;
    }

}
