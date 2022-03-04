package com.example.demo.queue.doubleBlocking;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: ln
 * @Date: 2022/3/1 11:17
 * @Description:
 */
public class Tools {
    public static LinkedBlockingQueue pl = new LinkedBlockingQueue(100);
    public static LinkedBlockingQueue tl = new LinkedBlockingQueue(100);
}
