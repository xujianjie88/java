package com.xjj.java.genericetype.dao;

import com.xjj.java.genericetype.entity.Student;
import org.junit.Test;

/**
 * @description:
 * @author: xujianjie
 * @create: 2021-07-10 17:54
 **/
public class DaoTest {
    @Test
    public void testSave(){
        StudentDao studentDao = new StudentDao();
        studentDao.save(new Student());
    }


}
