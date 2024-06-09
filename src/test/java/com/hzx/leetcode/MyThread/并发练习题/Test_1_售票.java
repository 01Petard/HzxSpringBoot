package com.hzx.leetcode.MyThread.并发练习题;


/**
 * 需求：
 * 一共有1000张电影票,可以在两个窗口领取,假设每次领取的时间为3000毫秒,
 * 请用多线程模拟卖票过程并打印剩余电影票的数量
 */
class MyThread_Test_1 extends Thread {

    //第一种方式实现多线程，测试类中MyThread会创建多次，所以需要加static
    static int ticket = 100;

    @Override
    public void run() {
        //1.循环
        while (true) {
            //2.同步代码块
            synchronized (MyThread_Test_1.class) {
                //3.判断共享数据（已经到末尾）
                if (ticket == 0) {
                    break;
                } else {
                    //4.判断共享数据（没有到末尾）
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + "在卖票第" + ticket + "张票，还剩下" + --ticket + "张票");
                }
            }
        }
    }
}

public class Test_1_售票 {
    public static void main(String[] args) {
       /*
            一共有1000张电影票,可以在两个窗口领取,假设每次领取的时间为3000毫秒,
            要求:请用多线程模拟卖票过程并打印剩余电影票的数量
        */

        //创建线程对象
        MyThread_Test_1 t1 = new MyThread_Test_1();
        MyThread_Test_1 t2 = new MyThread_Test_1();

        //给线程设置名字
        t1.setName("窗口1");
        t2.setName("窗口2");

        //开启线程
        t1.start();
        t2.start();

    }
}
