package com.xjj.java.trycatchfinally;

public class FinallyTest {


    public static void main(String[] args) {
        // һ����finally����ʹ����return��throw��䣬
        // ���ᵼ��try�飬catch���е�return��throw���ʧЧ
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
