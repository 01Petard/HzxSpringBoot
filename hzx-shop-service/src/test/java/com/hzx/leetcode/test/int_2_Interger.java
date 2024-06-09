package com.hzx.leetcode.test;

import java.util.Arrays;
import java.util.List;

public class int_2_Interger {
    public static void main(String[] args) {
        int[] nums = {5, 2, 1, 4, 3};

        Integer[] array = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        // 将数组转换为列表
        List<Integer> list = Arrays.asList(array);

        // 打印列表
        System.out.println(list);
    }
}
