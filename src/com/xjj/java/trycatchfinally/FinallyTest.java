package com.xjj.java.trycatchfinally;

public class FinallyTest {


    public static void main(String[] args) {
        // 一旦在finally块中使用了return或throw语句，
        // 将会导致try块，catch块中的return，throw语句失效
        System.out.println(returnTest());

        new Thread();
    }

    public static boolean returnTest()
    {
        try
        {
            return true;
        }
        catch (Exception e)
        {

        }
        finally
        {
            return false;
        }
    }

}
