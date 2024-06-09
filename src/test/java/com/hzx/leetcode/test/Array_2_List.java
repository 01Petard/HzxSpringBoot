package com.hzx.leetcode.test;

import java.util.Arrays;
import java.util.List;

public class Array_2_List {
    public static void main(String[] args) {
        String[] array = {"Red", "Green", "Blue", "Yellow"};

        // 使用stream流，将数组转换为集合
        List<String> list = Arrays.stream(array).toList();

        //用asList方法
        List<String> list2 = Arrays.asList(array);

        System.out.println("转换后的集合: " + list);
        System.out.println("转换后的集合: " + list2);
    }
}
