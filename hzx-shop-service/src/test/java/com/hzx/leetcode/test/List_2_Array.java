package com.hzx.leetcode.test;

import java.util.Arrays;
import java.util.List;

public class List_2_Array {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // 使用流将集合转换为数组
        String[] array = list.toArray(new String[0]);

        System.out.println("转换后的数组: " + Arrays.toString(array));

    }
}
