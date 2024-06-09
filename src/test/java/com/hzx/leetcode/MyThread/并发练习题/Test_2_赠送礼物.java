package com.hzx.leetcode.MyThread.并发练习题;

/**
 * 需求：
 * 有100份礼品,两人同时发送，当剩下的礼品小于10份的时候则不再送出。
 * 利用多线程模拟该过程并将线程的名字和礼物的剩余数量打印出来.
 */
class MyRunable_Test2 implements Runnable {

    //第二种方式实现多线程，测试类中MyRunable只创建一次，所以不需要加static
    int count = 100;

    @Override
    public void run() {
        //1.循环
        while (true) {
            //2.同步代码块
            synchronized (MyRunable_Test2.class) {
                //3.判断共享数据（已经到末尾）
                if (count < 10) {
                    System.out.println("礼物还剩下" + count + "不再赠送");
                    break;
                } else {
                    //4.判断共享数据（没有到末尾）
                    count--;
                    System.out.println(Thread.currentThread().getName() + "在赠送礼物，还剩下" + count + "个礼物!!!");
                }
            }
        }
    }
}


public class Test_2_赠送礼物 {
    public static void main(String[] args) {
        /*
            有100份礼品,两人同时发送，当剩下的礼品小于10份的时候则不再送出，
            利用多线程模拟该过程并将线程的名字和礼物的剩余数量打印出来.
        */

        //创建参数对象
        MyRunable_Test2 mr = new MyRunable_Test2();

        //创建线程对象
        Thread t1 = new Thread(mr, "窗口1");
        Thread t2 = new Thread(mr, "窗口2");

        //启动线程
        t1.start();
        t2.start();
    }
}
