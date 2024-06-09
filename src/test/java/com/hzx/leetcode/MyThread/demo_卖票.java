package com.hzx.leetcode.MyThread;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyThread extends Thread {

    static int ticket = 0;

    static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (ticket == 100) {
                    break;
                } else {
                    Thread.sleep(10);
                    ticket++;
                    System.out.println(getName() + "卖出了第" + ticket + "张票");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}


public class demo_卖票 {

    public static void main(String[] args) {

        /*
         * 用加锁实现卖票
         */
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
