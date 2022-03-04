package com.example.demo.queue.doubleBlocking;

/**
 * @Author: ln
 * @Date: 2022/3/1 11:45
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        producer.start();
        consumer.start();
        new DoubleBufferList(Tools.tl,Tools.pl).check();
    }

}
