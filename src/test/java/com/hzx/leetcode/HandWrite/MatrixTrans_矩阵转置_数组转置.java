package com.hzx.leetcode.HandWrite;

/**
 * 将一个矩阵（数组）转置
 */
public class MatrixTrans_矩阵转置_数组转置 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{4, 5, 6}, {2, 3, 9}, {1, 2, 3}};
        int[][] arrtrans = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arrtrans[j][i] = arr[i][j];
            }
        }
        for (int[] arrtran : arrtrans) {
            for (int j = 0; j < arrtrans[0].length; j++) {
                System.out.print(arrtran[j] + " ");
            }
            System.out.println();
        }
    }
}
