package com.hzx.mianshi;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入一个整数：");
        int num = scanner.nextInt();

        System.out.println("你输入的整数是：" + num);

        System.out.print("请输入一个字符：");
        char ch = scanner.next().charAt(0);

        System.out.println("你输入的字符是：" + ch);


        // 循环读取字符，直到用户输入"exit"退出
        while (true) {
            System.out.print("请输入一个字符（输入'exit'退出）：");
            String input = scanner.next();

            // 检查用户输入是否为"exit"，如果是则退出循环
            if (input.equals("exit")) {
                break;
            }

            // 获取输入的第一个字符
            ch = input.charAt(0);

            System.out.println("你输入的字符是：" + ch);
        }


        scanner.close(); // 记得关闭Scanner对象



    }


}
