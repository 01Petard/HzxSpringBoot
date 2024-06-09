package com.hzx.leetcode.Algorithm;

import com.hzx.leetcode.util.MyArray;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Stack;


/**
 * 常见排序算法
 */
public class Sort {

    /**
     * 交换数组R中索引i和j的元素
     * @param R 待排序数组
     * @param i 索引i
     * @param j 索引j
     */
    private static void swap(int[] R, int i, int j) {
        int temp = R[i];
        R[i] = R[j];
        R[j] = temp;
    }


    /**
     * 插入排序
     * @param R 待排序数组
     */
    public static void InsertSort(int[] R) {
        int i, j, temp;
        for (i = 1; i < R.length; i++) {
            temp = R[i];
            for (j = i - 1; j >= 0; j--) {
                if (temp < R[j]) R[j + 1] = R[j];
                else break;
            }
            R[j + 1] = temp;
        }
    }

    /**
     * 插入排序（优化版）
     * 优化操作：
     * 1、减少赋值操作：在当前元素找到合适位置之前，需要将比它大的元素都向右移动一位，这会导致多次赋值操作。可以使用一个临时变量来保存当前元素的值，在找到合适位置后再进行赋值操作。
     * 2、减少比较次数：内部循环中，可以在不满足条件时就退出，而不必继续比较。可以改用 while 循环来实现这一点。
     * @param R 待排序数组
     */
    public static void InsertSort_optimized(int[] R) {
        int i, j, temp;
        for (i = 1; i < R.length; i++) {
            temp = R[i];
            j = i - 1;
            // 移动比当前元素大的元素，为当前元素腾出插入位置
            while (j >= 0 && R[j] > temp) {
                R[j + 1] = R[j];
                j--;
            }
            // 将当前元素插入合适的位置
            R[j + 1] = temp;
        }
    }

    /**
     * 冒泡排序
     * @param R 待排序数组
     */
    public static void BobSort(int[] R) {
        int i, j, temp;
        for (i = R.length - 1; i > 0; i--) {
            for (j = 0; j < i; j++) {
                if (R[j] > R[j + 1]) swap(R, j, j+1);

            }
        }
    }

    /**
     * 冒泡排序（优化版）
     * 优化操作：
     * 1、添加早期退出条件：在内部循环中，如果某次迭代没有发生交换，说明数组已经是有序的，可以提前退出外部循环，而不必继续迭代。
     * 2、减少比较次数：外部循环每迭代一次，就会确定一个最大值，所以内部循环可以减少一次迭代。
     * 3、检查边界：在交换元素之前，应该确保 j + 1 不超出数组边界。
     * @param R 待排序数组
     */
    public static void BobSort_optimized(int[] R) {
        int i, j, temp;
        boolean swapped;
        for (i = R.length - 1; i > 0; i--) {
            swapped = false;
            for (j = 0; j < i; j++) {
                if (R[j] > R[j + 1]) {
                    swap(R, j, j+1);
                    swapped = true;
                }
            }
            // 如果没有发生交换，说明数组已经是有序的，提前退出循环
            if (!swapped) {
                break;
            }
        }
    }


    /**
     * 选择排序
     * @param R 待排序数组
     */
    public static void SelectSort(int[] R) {
        int i, j, k, temp;
        for (i = 0; i < R.length; i++) {
            k = i;
            for (j = i + 1; j < R.length; j++) {
                if (R[j] < R[k]) {
                    k = j;
                }
            }
            swap(R, i, k);
        }
    }

    /**
     * 选择排序（优化版）
     * 优化操作：
     * 1、减少交换次数：当前实现中，每次在内部循环中找到最小值后，都会进行一次交换。可以优化为只在外部循环结束时进行一次交换。
     * 2、减少比较次数：内部循环中，可以避免对已排序部分的元素进行比较。
     * @param R 待排序数组
     */
    public static void SelectSort_optimized(int[] R) {
        int i, j, k, temp;
        for (i = 0; i < R.length - 1; i++) {
            k = i;
            for (j = i + 1; j < R.length; j++) {
                if (R[j] < R[k]) {
                    k = j;
                }
            }
            // 只在外部循环结束时进行交换
            if (k != i) swap(R, i, k);
        }
    }

    /**
     * 归并排序
     * @param R     待排序数组
     * @param left  开始位置
     * @param right 结束位置
     */
    public static void mergeSort(int[] R, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(R, left, mid);
        mergeSort(R, mid + 1, right);
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (R[i] <= R[j]) {
                temp[k++] = R[i++];
            } else {
                temp[k++] = R[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = R[i++];
        }
        while (j <= right) {
            temp[k++] = R[j++];
        }
        for (i = left, k = 0; i <= right; i++, k++) {
            R[i] = temp[k];
        }
    }

    /**
     * 快速排序
     * @param R     待排序数组
     * @param left  开始位置
     * @param right 结束位置
     */
    public static void quickSort(int[] R, int left, int right) {
        if (left < right) {
            int pivot = partition(R, left, right);  //获取临界点
            quickSort(R, left, pivot - 1);
            quickSort(R, pivot + 1, right);
        }
    }

    public static int partition(int[] R, int left, int right) {
        int pivot = R[left];
        while (left < right) {
            while (left < right && R[right] >= pivot) right--;
            R[left] = R[right];
            while (left < right && R[left] <= pivot) left++;
            R[right] = R[left];
        }
        R[left] = pivot;
        return left;
    }


    /**
     * 快速排序，自定义排序的开始位置和结束位置
     * @param R    待排序数组
     * @param low  开始位置
     * @param high 结束位置
     */
    public static void QuickSort(int[] R, int low, int high) {
        int i = low, j = high, temp;
        if (low < high) {
            temp = R[low];
            while (i < j) {
                while (i < j && temp < R[j]) --j;
                if (i < j) {
                    R[i] = R[j];
                    ++i;
                }
                while (i < j && temp > R[i]) ++i;
                if (i < j) {
                    R[j] = R[i];
                    --j;
                }
            }
            R[i] = temp;
            QuickSort(R, low, i - 1);
            QuickSort(R, i + 1, high);
        }
    }

    /**
     * 快速排序，排序整个数组
     * @param R 待排序数组
     */
    public static void QuickSort(int[] R) {
        QuickSort(R, 0, R.length - 1);
    }


    /**
     * 非递归快速排序
     * 优化操作：
     * 1、优化递归：当前实现使用了递归来对分割后的子数组进行排序，但是递归深度可能会很大，导致栈溢出。可以使用非递归的方式来实现快速排序，使用一个栈或者队列来模拟递归的过程。
     * 2、优化划分点选择：当前实现中，划分点选择的方式是选取子数组的第一个元素，这可能导致最坏情况的发生。可以采用更加合理的方式选择划分点，如取中值或者随机选择。
     * 3、优化对于已经有序数组的性能：当前实现对于已经有序的数组或者部分有序数组的性能不佳。可以在划分阶段对数组进行预处理，例如使用三数取中法等方式来避免最坏情况的发生。
     * @param R 待排序数组
     */
    public static void QuickSort_optimized(int[] R, int low, int high) {
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);

        Random rand = new Random();

        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();

            if (low < high) {
                int pivotIndex = partition(R, low, high, rand);

                if (pivotIndex - 1 > low) {
                    stack.push(low);
                    stack.push(pivotIndex - 1);
                }

                if (pivotIndex + 1 < high) {
                    stack.push(pivotIndex + 1);
                    stack.push(high);
                }
            }
        }
    }


    /**
     * 划分操作：将数组分割成两部分，并返回划分点的索引
     * @param R    待排序数组
     * @param low  划分的起始位置
     * @param high 划分的结束位置
     * @param rand 随机数生成器
     * @return 划分点的索引
     */
    private static int partition(int[] R, int low, int high, Random rand) {
        int pivotIndex = low + rand.nextInt(high - low + 1);
        int pivotValue = R[pivotIndex];
        swap(R, pivotIndex, high);

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (R[j] < pivotValue) {
                i++;
                swap(R, i, j);
            }
        }

        swap(R, i + 1, high);
        return i + 1;
    }


    /**
     * 快速排序，使用随机数生成器来优化划分点选择
     * @param R 待排序数组
     */
    public static void QuickSort_optimized(int[] R) {
        QuickSort_optimized(R, 0, R.length - 1);
    }


    /**
     * 计数排序（优化版）
     * 优化操作：普通计数排序在待排序数组范围较大时会浪费大量空间。优化的计数排序通过统计每个元素出现的频率来避免为每个可能的值分配计数数组的空间。
     * @param R 待排序数组
     */
    public static void CountingSort_optimized(int[] R) {
        if (R == null || R.length == 0)
            return;

        int min = Arrays.stream(R).min().getAsInt();
        int max = Arrays.stream(R).max().getAsInt();
        int range = max - min + 1;

        int[] count = new int[range];
        for (int num : R) {
            count[num - min]++;
        }

        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i] > 0) {
                R[index++] = i + min;
                count[i]--;
            }
        }
    }

    public static void printList(int[] nums, int maxElementsToPrint) {
        List<Integer> list = Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new));

        if (list.size() <= maxElementsToPrint) {
            for (Object object : list) {
                System.out.print(object + " ");
            }
        } else {
            for (int i = 0; i < maxElementsToPrint; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.print(" ...\n");
        }
    }


    private static void test_performance() {
        //快速初始化一个数组
        int[] nums = MyArray.rangeArray(1, 10000, 2000);
        //输出排序前序列
        System.out.println("初始序列：");
        printList(nums, 10);


        //测试的排序算法
//        Sort.BobSort_optimized(nums);
//        Sort.InsertSort_optimized(nums);
//        Sort.SelectSort_optimized(nums);
//        Sort.QuickSort_optimized(nums);
//        Sort.quickSort(nums, 0, nums.length - 1);
//        Sort.mergeSort(nums, 0, nums.length - 1);
        Sort.CountingSort_optimized(nums);


        //输出排序后序列
        System.out.println("\n升序序列：");
        printList(nums, 10);


    }


    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();


        test_performance();


        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("\n代码运行时间（毫秒）：" + elapsedTime + " ms");

    }


}
