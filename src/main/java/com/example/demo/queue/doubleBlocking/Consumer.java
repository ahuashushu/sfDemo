package com.example.demo.queue.doubleBlocking;

/**
 * @Author: ln
 * @Date: 2022/3/1 11:32
 * @Description:
 */
public class Consumer extends Thread {
    long start = System.currentTimeMillis();
    int count = 0;
    @Override
    public void run(){
        while (true) {
            try {
                Tools.tl.take();
                System.out.println("消费");
                count++;
                if (count == 100) {
                    System.out.println(System.currentTimeMillis() - start);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
