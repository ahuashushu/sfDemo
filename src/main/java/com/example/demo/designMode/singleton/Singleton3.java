package com.example.demo.designMode.singleton;

/**
 * @Author: ln
 * @Date: 2022/2/28 16:06
 * @Description:
 */
public class Singleton3 {
    private static Singleton3 singleton3 = null;

    private Singleton3(){
        System.out.println("加载3");
    }

    public synchronized static Singleton3 getInstance(){
        if (singleton3 == null){
            singleton3 = new Singleton3();
        }
        return singleton3;
    }
}
