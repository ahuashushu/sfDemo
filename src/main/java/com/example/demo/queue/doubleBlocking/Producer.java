package com.example.demo.queue.doubleBlocking;

/**
 * @Author: ln
 * @Date: 2022/3/1 11:15
 * @Description:
 */
public class Producer extends Thread {
    @Override
    public void run(){
        while (true){
            try {
                Tools.pl.put(System.currentTimeMillis());
                System.out.println("生产");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
