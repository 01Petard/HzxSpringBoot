package com.hzx.leetcode.MyThread;

import java.util.concurrent.*;


class MyCallable implements Callable<Integer> {

    static int sum = 0;

    @Override
    public Integer call() {
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}


class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}


public class demo_线程池 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService pool = Executors.newCachedThreadPool();
        ExecutorService pool = Executors.newFixedThreadPool(3);

//        pool.submit(new MyRunnable());
//        pool.submit(new MyRunnable());
//        pool.submit(new MyRunnable());
//        pool.submit(new MyRunnable());
//        pool.submit(new MyRunnable());
//        pool.submit(new MyRunnable());
        pool.submit(new MyRunnable());


        Future<Integer> submit = pool.submit(new MyCallable());

        System.out.println(submit.get());

        pool.shutdown();


    }


}
