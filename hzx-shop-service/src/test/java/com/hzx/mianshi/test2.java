package com.hzx.mianshi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class test2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个自然数: ");
        int n = scanner.nextInt();
        List<Integer> nums = findNums(n);
        nums.sort(Collections.reverseOrder()); // 倒序排列
        for (int num : nums) {
            System.out.println(num);
        }
        scanner.close();
    }

    public static List<Integer> findNums(int limit) {
        List<Integer> narcissisticNumbers = new ArrayList<>();
        for (int i = 10; i < limit; i++) {
            if (isNum(i)) {
                narcissisticNumbers.add(i);
            }
        }
        return narcissisticNumbers;
    }

    public static boolean isNum(int number) {
        int originalNumber = number;
        int sum = 0;
        int digits = String.valueOf(number).length();
        while (number > 0) {
            int digit = number % 10;
            sum += (int) Math.pow(digit, digits);
            number /= 10;
        }
        return sum == originalNumber;
    }

}
