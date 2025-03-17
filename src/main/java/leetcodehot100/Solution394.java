package leetcodehot100;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/*
给定一个经过编码的字符串，返回它解码后的字符串。
编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

示例 1：
输入：s = "3[a]2[bc]"
输出："aaabcbc"

示例 2：
输入：s = "3[a2[c]]"
输出："accaccacc"

示例 3：
输入：s = "2[abc]3[cd]ef"
输出："abcabccdcdcdef"

示例 4：
输入：s = "abc3[cd]xyz"
输出："abccdcdcdxyz"
 */
/**
 * 因为存在括号嵌套的情况，所以要用栈进行处理。
 */
class Solution394 {
    int index = 0;

    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();

        while (index < s.length()) {
            char cur = s.charAt(index);
            if (Character.isDigit(cur)) {
                // 如果当前的字符是数字，就解析出来一个数字并进栈
                String digits = getDigits(s);
                stack.push(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                // 如果当前字符为字母或者左括号，直接进栈
                stack.push(String.valueOf(s.charAt(index)));
                index++;
            } else {
                // 如果当前的字符为右括号，开始出栈，一直到左括号出栈，出栈序列反转后拼接成一个字符串，
                // 此时取出栈顶的数字（此时栈顶一定是数字，想想为什么？）因为这道题的代码总是正确的（正确就意味着一定是数字）
                // 就是这个字符串应该出现的次数，我们根据这个次数和字符串构造出新的字符串并进栈
                index++;
                Stack<String> temp = new Stack<>();
                //一直出栈，直到出到左括号。说明字母才出完。
                while (!"[".equals(stack.pop())) {
                    temp.push(stack.pop());
                }
                //由于是在栈里面进行存储的，所以顺序就是反着的。需要进行翻转。
                Collections.reverse(temp);
                // 左括号出栈
                stack.pop();
                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                int letterCount = Integer.parseInt(stack.pop());
                StringBuilder stringBuilder = new StringBuilder();
                String o = getString(temp);
                // 构造字符串
                while (letterCount > 0) {
                    stringBuilder.append(o);
                    letterCount--;
                }
                // 将构造好的字符串入栈
                stack.push(stringBuilder.toString());
            }
        }

        return getString(stack);
    }

    /**
     * 这个方法会根据传入的index为下标，查找出来第一个数字，如果13[a] 就会解析出来13
     *
     * @param s
     * @return
     */
    public String getDigits(String s) {
        StringBuilder ret = new StringBuilder();
        while (Character.isDigit(s.charAt(index))) {
            ret.append(s.charAt(index++));
        }
        return ret.toString();
    }

    /**
     * 这个方法通过传入一个栈
     * 比如集合内容是[a,b],会返回ab字符串。
     */
    public String getString(Stack<String> v) {
        StringBuilder ret = new StringBuilder();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }
}
