package com.xjj.java.exception;

/**
 * 在写异常处理的时候，一定要把异常范围小的放在前面，范围大的放在后面
 */
public class TestException {

    public static void main(String[] args) {
        int x = 10;
        int y = 0;
        try{
            System.out.println(x / y);
        }catch (ArithmeticException e){
            System.out.println("处理被除数为0的异常");
            e.printStackTrace();
        }catch (Exception e){
            //这里不会执行
            System.out.println("处理其他异常");
            e.printStackTrace();
        }finally {
            System.out.println("一定会执行的部分");
        }
        System.out.println("异常处理成功");
    }
}
