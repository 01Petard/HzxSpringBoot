package com.hzx.leetcode.HandWrite;

public class PalindromeChecker_判断是否是回文 {

    public static boolean isPalindrome(String str) {
        // 去除空格和非字母数字字符，并转换为小写
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        str = sb.toString();

        // 使用双指针法进行比较
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("race a car")); // false
        System.out.println(isPalindrome("acbbca")); // true
        System.out.println(isPalindrome("abcba")); // true
    }

}
