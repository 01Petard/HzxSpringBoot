package com.hzx.leetcode.MyThread;

import java.util.concurrent.ConcurrentHashMap;

public class demo_ConcurrentHashMap {

//    static Hashtable<String, String> hm = new Hashtable<>();

    static ConcurrentHashMap<String, String> hm = new ConcurrentHashMap<>(100);
    
    public static void addData() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 25; i++) {
                hm.put(String.valueOf(i), String.valueOf(i));
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 25; i < 51; i++) {
                hm.put(String.valueOf(i), String.valueOf(i));
            }
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) throws InterruptedException {

        addData();

        System.out.println("----------------------------");
        //等待t1和t2把数据全部添加完毕
        Thread.sleep(1000);
        
        //0-0 1-1 ..... 50- 50

        for (int i = 0; i < 51; i++) {
            System.out.println(hm.get(i + ""));
        }//0 1 2 3 .... 50


    }
}
