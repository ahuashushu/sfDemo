package com.example.demo.designMode.singleton;

/**
 * @Author: ln
 * @Date: 2022/2/28 16:02
 * @Description:双重校验锁
 */
public class Singleton2 {
    private static volatile Singleton2 singleton2 = null;
    private Singleton2(){
        System.out.println("加载2");
    }

    public static Singleton2 getInstance(){
        if (singleton2 == null){
            synchronized (Singleton2.class){
                if (singleton2 == null){
                    singleton2 = new Singleton2();
                }
            }
        }
        return singleton2;
    }
}
