package com.example.demo.designMode.singleton;

/**
 * @Author: ln
 * @Date: 2022/2/28 15:56
 * @Description: 静态内部类方式
 */
public class Singleton1 {
    private Singleton1(){
        System.out.println("加载1");
    }

    private static class T{
        private static Singleton1 t = new Singleton1();
    }

    public static Singleton1 getInstance(){
        return T.t;
    }
}
