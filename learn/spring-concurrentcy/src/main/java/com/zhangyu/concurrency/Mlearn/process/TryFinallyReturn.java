package com.zhangyu.concurrency.Mlearn.process;

public class TryFinallyReturn {

    public static void main(String[] args) {
        tryFinallyReturnTest();
        System.out.println("over");
    }

    private static void tryFinallyReturnTest() {
        boolean flag = true;
        try {
            System.out.println("try");
            if (flag) {
                return;
            }
            System.out.println("return begin Exception");
            if (flag) {
                throw new Exception("ee");
            }
            System.out.println("return");
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
    }
    //try
    //finally
    //over


}
