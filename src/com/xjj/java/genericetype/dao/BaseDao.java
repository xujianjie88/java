package com.xjj.java.genericetype.dao;

import java.util.List;

/**
 * @description: ��װ��������ɾ�Ĳ�
 * @author: xujianjie
 * @create: 2021-07-10 17:44
 **/
public abstract class BaseDao<T> {

    //����
    boolean save(T o) {
        return true;
    }

    //�༭
    int update(T o){
        return 0;
    }

    //��ѯ
    List<T> selectList(T condition){
        return null;
    }

    //ɾ��
    void remove(T o){
    }

    //���ͷ������ʹ����Tûɶ��ϵ
    <E> E getValue(E e){
      return null;
    }

}
