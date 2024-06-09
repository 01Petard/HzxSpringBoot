package com.hzx.leetcode.LeetCode;

import com.hzx.leetcode.util.MyListNode;

import java.util.HashSet;

/*
 * 原题链接：https://leetcode.cn/problems/kth-node-from-end-of-list-lcci/description/
 */
public class Solution_面试题_0202_返回倒数第k个节点 {


    public static void main(String[] args) {

        HashSet<String> set = new HashSet<>();
        set.add("三");
        set.add("更");
        set.add("草");
        set.add("堂");

        String[] strings = set.toArray(new String[0]);
        for (String string : strings) {
            System.out.println(string);
        }


    }

    public static int kthToLast(MyListNode head, int k) {
        return 1;
    }

}
