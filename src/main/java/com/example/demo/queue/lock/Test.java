package com.example.demo.queue.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: ln
 * @Date: 2022/3/1 10:32
 * @Description:
 */
public class Test {
    Lock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();
    Object[] objects = new Object[10];
    int putptr = 0, takeptr = 0, count = 0;

    public void put(Object o){
        lock.lock();
        try{
            while (count == objects.length){
                System.out.println("满了");
                notFull.await();
            }
            objects[putptr++] = o;
            count++;
            if (putptr == objects.length){
                putptr = 0;
            }
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Object get(){
        Object o = null;
        lock.lock();
        try {
            while (count == 0){
                System.out.println("空了");
                notEmpty.await();
            }
            o = objects[takeptr++];
            count--;
            if (takeptr == objects.length){
                takeptr = 0;
            }
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return o;
    }


    public static void main(String[] args) {
        Test test = new Test();
        new Thread(() -> {
            for (int i = 0; i < 100; i++ ){
                test.put(i);
                System.out.println("生产" + i);
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 40 ; i++){
                int k = (int)test.get();
                System.out.println("A消费" + k);
            }
        }).start();

        System.out.println("----------------");

        new Thread(() -> {
            for (int i = 0; i < 66 ; i++){
                int k = (int)test.get();
                System.out.println("B消费" + k);
            }
        }).start();
    }
}
