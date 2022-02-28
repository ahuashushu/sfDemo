package com.example.demo.designMode.singleton;

/**
 * @Author: ln
 * @Date: 2022/2/28 16:10
 * @Description:
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Singleton1.getInstance();
        Singleton2.getInstance();
//        Singleton3.getInstance();
        Thread.sleep(3000);
        Singleton1.getInstance();
        Singleton2.getInstance();
        Singleton3.getInstance();
    }
}
