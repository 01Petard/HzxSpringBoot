package com.hzx.leetcode.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test_1234 {

     static class B{

         static {
             System.out.println("static B");
         }
         {
             System.out.println("B");
         }
        public B(){
            System.out.println("create B");
        }

         public void say(){
             System.out.println("say B");
         }

         public void run(){
             System.out.println("run B");
         }


    }


    static class A extends B{
        static {
            System.out.println("static A");
        }
        {
            System.out.println("A");
        }

        public A(){
            System.out.println("create A");
        }

        public void say(){

            System.out.println("say A");

        }

        public void cry(){

            System.out.println("cry A");

        }


    }

    public static int printInt(){
        try{
            int i = 1/0;
        }catch (Exception e){
            return 3;
        }finally {
            return 1;
        }
    }


    public static void main(String[] args) {
        B b = new A();
        b.say();
        b.run();

        System.out.println(printInt());

        final Lock lock = new ReentrantLock();
        final Condition conditionA = lock.newCondition();
        conditionA.signal();


    }



}
