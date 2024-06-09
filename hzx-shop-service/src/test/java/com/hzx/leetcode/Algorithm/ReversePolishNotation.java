package com.hzx.leetcode.Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


/**
 * 逆波兰表达式求值
 * 这是一种后缀表达式，其中运算符在操作数之后。实现逆波兰表达式的求值，可以使用栈来存储操作数，遇到运算符时进行计算。
 */
public class ReversePolishNotation {
    public static void main(String[] args) {
        String suffixExpression = "3 4 + 5 * 6 -";
        List<String> rpnList = getListString(suffixExpression);
        System.out.println(calculate(rpnList));
    }

    private static List<String> getListString(String suffixExpression) {
        String[] strings = suffixExpression.split(" ");
        ArrayList<String> stringList = new ArrayList<>();
        Collections.addAll(stringList, strings);
        return stringList;
    }

    private static Integer calculate(List<String> list) {
        Stack<Integer> stack = new Stack<>();

        for (String item : list) {
            if (item.matches("\\d+")) {
                //数字
                stack.push(Integer.valueOf(item));
            } else {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                int res;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("无效运算符");
                }
                stack.push(res);
            }
        }
        return stack.pop();


    }
}
