package leetcodehot100;

import java.util.Deque;
import java.util.LinkedList;

/*
给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。

示例 1：
输入：s = "1 + 1"
输出：2

示例 2：
输入：s = " 2-1 + 2 "
输出：3

示例 3：
输入：s = "(1+(4+5+2)-3)+(6+8)"
输出：23
 */
class Solution224 {
    public int calculate(String s) {
        // 使用双端队列存储每个括号层级的符号
        Deque<Integer> deque = new LinkedList<>();
        deque.push(1);
        int sign = 1;  // 当前数字的符号

        int res = 0;  // 最终结果
        int n = s.length();// 传入的字符串长度
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;  // 跳过空格
            } else if (s.charAt(i) == '+') {
                sign = deque.peek();  // 更新符号为当前层级的符号
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -deque.peek();  // 更新符号为当前层级符号的相反数
                i++;
            } else if (s.charAt(i) == '(') {
                deque.push(sign);  // 将当前符号压入栈，进入新的层级
                i++;
            } else if (s.charAt(i) == ')') {
                deque.pop();  // 退出当前层级
                i++;
            } else {
                long num = 0;
                // 解析多位数字
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                res += sign * num;  // 将数字加到结果中，考虑其符号
            }
        }
        return res;  // 返回最终计算结果
    }
}