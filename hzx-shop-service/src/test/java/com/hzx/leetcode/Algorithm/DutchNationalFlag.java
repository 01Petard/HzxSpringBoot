package com.hzx.leetcode.Algorithm;

import java.util.Arrays;

/**
 * 荷兰三色旗问题（简化版）
 * 给定一个包含红、白、蓝三色元素的数组，编写一个函数来排序该数组，使得数组的前半部分都是红元素，后半部分都是白元素，中间元素都是蓝元素。
 */
public class DutchNationalFlag {

    public static void sortColoes(int[] nums) {
        int left = 0, right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, right);
                right--;
            } else {
                i++;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {

        int[] nums = {1,2,0,2,1,2,1,0,1,0,2,1};
        sortColoes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
