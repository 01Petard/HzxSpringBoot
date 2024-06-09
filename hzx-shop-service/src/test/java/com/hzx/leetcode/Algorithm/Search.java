package com.hzx.leetcode.Algorithm;

import com.hzx.leetcode.util.MyArray;

import java.util.Scanner;


/**
 * 常见搜索算法
 */
public class Search {


    /**
     * 二分查找，查找整个数组（重载方法）
     *
     * @param R   待查找数组
     * @param key 查找关键字
     * @return 返回关键字的下标
     */
    public static int BinSearch(int[] R, int key) {
        return BinSearch(R, R.length - 1, key, 0);
    }


    /**
     * 二分查找，自定义查找的开始位置和结束位置
     *
     * @param R    待查找数组
     * @param low  开始位置
     * @param high 结束位置
     * @param key  查找关键字
     * @return 返回关键字的下标
     */
    public static int BinSearch(int[] R, int key, int low, int high) {
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (key < R[mid]) {
                high = mid - 1;
            } else if (key > R[mid]) {
                low = mid + 1;
            } else if (key == R[mid]) {
                return mid;
            }
        }
        return -1;
    }


    public static void MergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            MergeSort(nums, low, mid);
            MergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= high) {
            temp[k++] = nums[j++];
        }
        for (int m = 0; m < temp.length; m++) {
            nums[low + m] = temp[m];
        }
    }


    public static void main(String[] args) {


        //快速初始化一个数组
        int[] nums = MyArray.rangeArray();
        //输出排序前序列
        System.out.println("初始序列：");
        for (int data : nums) {
            System.out.print(data + " ");
        }

        //排序后序列
        Sort.QuickSort(nums);
        //输出排序后序列
        System.out.println("\n升序序列：");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        int key;
        System.out.println("\n请输入你要查找的关键字：");
        Scanner s = new Scanner(System.in);
        key = s.nextInt();
        int index = Search.BinSearch(nums, key);
        //输出查找结果
        if (index == -1) {
            System.out.println("你要查找的关键字" + key + "不存在！");
        } else {
            System.out.println("你要查找的关键字：" + key + "，下标：" + index);
        }
    }

}
