package com.example.demo.queue.blockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * @Author: ln
 * @Date: 2022/3/1 9:37
 * @Description:
 */
public class Consumer implements Runnable {
    private final BlockingQueue blockingQueue;
    int count = 0;
    long start = System.currentTimeMillis();

    public Consumer(BlockingQueue queue){
        this.blockingQueue = queue;
    }
    @Override
    public void run() {
        while (true){
            try {
                long i = (long)blockingQueue.take();
//                System.out.println("Consumer：" + i);
                count++;
                if (count == 10000000){
                    System.out.println(System.currentTimeMillis() - start);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
