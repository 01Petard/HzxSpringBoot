package com.hzx.leetcode.Algorithm;


/**
 * 字符串转整数
 */
public class StringToInteger {
    public static int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }
        int sign = 1;
        int i = 0;
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            sign = str.charAt(i++) == '+' ? 1 : -1;
        }
        int result = 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int digit = str.charAt(i) - '0';
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        return sign * result;
    }

    public static void main(String[] args) {
        String str = "  -4 11 2 ";
        int result = myAtoi(str);
        System.out.println("字符串转换整数的结果为：" + result); // 输出：字符串转换整数的结果为：-42
    }
}
