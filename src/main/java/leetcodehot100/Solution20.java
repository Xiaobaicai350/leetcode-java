package leetcodehot100;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution20 {
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

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            //模拟栈的弹栈和入栈
            char ch = s.charAt(i);//()
            if (pairs.containsKey(ch)) {//如果是)]}的话
                if (stack.peek() != pairs.get(ch)) {//需要判断栈顶
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
