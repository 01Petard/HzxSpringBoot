package com.hzx.leetcode.Algorithm;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 荷兰三色旗问题（并行）
 */
public class DutchNationalFlagParallel {
    private static final int RED = 0;
    private static final int WHITE = 1;
    private static final int BLUE = 2;

    public static void sort(int[] array) {
        int[] sorted = IntStream.of(array) // 创建一个int类型的流，从给定的数组array中
                .parallel() // 将流转换为并行流，这样流的操作可以并行执行
                .boxed() // 将int类型的流转换为Integer类型的流，因为Integer是对象，可以调用更多的方法
                .sorted((a, b) -> { // 对流中的元素进行排序
                    if (a == b) return 0; // 如果两个元素相等，返回0，表示它们的位置不变
                    else if (a == RED && b != RED) return -1; // 如果a是红色且b不是红色，a应该排在b前面，返回-1
                    else if (b == RED && a != RED) return 1; // 如果b是红色且a不是红色，b应该排在a前面，返回1
                    else if (a == WHITE && b != WHITE) return -1; // 如果a是白色且b不是白色，a应该排在b前面，返回-1
                    else if (b == WHITE && a != WHITE) return 1; // 如果b是白色且a不是白色，b应该排在a前面，返回1
                    else return 1; // 否则，默认b（蓝色）排在a（非红非白）前面，返回1
                })
                .mapToInt(Integer::intValue) // 将排序后的Integer流转换回int流
                .toArray(); // 将流转换为数组

        System.arraycopy(sorted, 0, array, 0, sorted.length);
    }

    public static void main(String[] args) {
        int[] array = {RED, WHITE, RED, BLUE, WHITE, RED, WHITE, BLUE};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
