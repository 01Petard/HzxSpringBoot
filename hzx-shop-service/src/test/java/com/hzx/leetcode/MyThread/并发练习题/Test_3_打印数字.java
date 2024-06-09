package com.hzx.leetcode.MyThread.并发练习题;

class MyRunable_Test3 implements Runnable {

    //第二种方式实现多线程，测试类中MyRunable只创建一次，所以不需要加static
    int number = 1;

    @Override
    public void run() {
        //1.循环
        while (true) {
            //2.同步代码块
            synchronized (MyRunable_Test3.class) {
                //3.判断共享数据（已经到末尾）
                if (number > 1000) {
                    break;
                } else {
                    //4.判断共享数据（没有到末尾）
                    if(number % 2 == 1){
                        System.out.println(Thread.currentThread().getName() + "打印数字" + number);
                    }
                    number++;
                }
            }
        }
    }
}


public class Test_3_打印数字 {
    public static void main(String[] args) {
        /*
           同时开启两个线程，共同获取1-100之间的所有数字。
           要求：将输出所有的奇数。
        */


        //创建参数对象
        MyRunable_Test3 mr = new MyRunable_Test3();

        //创建线程对象
        Thread t1 = new Thread(mr,"线程A");
        Thread t2 = new Thread(mr,"线程B");

        //启动线程
        t1.start();
        t2.start();
    }
}

