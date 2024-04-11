package leetcodehot100;

import java.util.Stack;

/**
 * 通过一个栈来模拟，就好了，debug一下
 */
class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            //如果栈里有元素的话 并且 当前的元素大于栈顶的元素(主要是后面这个，前面是安全性校验)
            //就需要出栈
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                //得到栈顶元素的值
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }

            stack.push(i);
        }

        return ans;
    }
}