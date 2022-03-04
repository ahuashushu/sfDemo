package com.example.demo.queue.doubleBlocking;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: ln
 * @Date: 2022/3/1 11:38
 * @Description:
 */
public class DoubleBufferList {
    private LinkedBlockingQueue tl;
    private LinkedBlockingQueue pl;

    public DoubleBufferList(LinkedBlockingQueue tl, LinkedBlockingQueue pl){
        this.tl = tl;
        this.pl = pl;
    }

    public void check(){
        new Thread(() -> {
            while (true) {
                if (tl.size() == 0) {
                    synchronized (tl) {
                        synchronized (pl) {
                            tl.addAll(pl);
                        }
                        pl.clear();
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

//    public void check(){
//        System.out.println("check");
//        Runnable runner = new Runnable(){
//            @Override
//            public void run() {
//                while(true){
//                    if(tl.size()==0){
//                        synchronized(tl){
//                            synchronized(pl){
//                                tl.addAll(pl);
//                            }
//                            pl.clear();
//                        }
//                    }
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            }
//        };
//        Thread thread = new Thread(runner);
//        thread.start();
//    }
}
