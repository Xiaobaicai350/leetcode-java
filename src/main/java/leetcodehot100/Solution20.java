package leetcodehot100;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。


示例 1：
输入：s = "()"
输出：true

示例 2：
输入：s = "()[]{}"
输出：true

示例 3：
输入：s = "(]"
输出：false

示例 4：
输入：s = "([])"
输出：true
 */
class Solution20 {
    //判断字符串是否有效
    public boolean isValid(String s) {
        int n = s.length();
        //如果长度为奇数，直接返回
        if (n % 2 == 1) {
            return false;
        }
        //注意这个map里面的数据是反着的
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        //新建一个栈
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            //模拟栈的弹栈和入栈
            char ch = s.charAt(i);//
            if (pairs.containsKey(ch)) {//如果是)]}的话
                if (stack.peek() != pairs.get(ch)) {//需要判断栈顶
                    return false;
                }
                stack.pop();
            } else {//如果是([{的话
                stack.push(ch);//压栈
            }
        }
        return stack.isEmpty();
    }
}
