package com.example.demo.queue.blockingQueue;

import java.util.concurrent.BlockingQueue;

/**
 * @Author: ln
 * @Date: 2022/2/28 18:06
 * @Description:
 */
public class Producer implements Runnable {
    private final BlockingQueue blockingQueue;

    public Producer(BlockingQueue queue){
        this.blockingQueue = queue;
    }

    @Override
    public void run() {
//        for (int i = 0; i < 10; i++){
//            try {
//                System.out.println("producer：" + i);
//                blockingQueue.put(i);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        while (true){
            try{
                blockingQueue.put(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
