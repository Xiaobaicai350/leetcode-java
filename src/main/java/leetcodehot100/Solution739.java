package leetcodehot100;

import java.util.Stack;

/*
给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
如果气温在这之后都不会升高，请在该位置用 0 来代替。

示例 1:
输入: temperatures = [73,74,75,71,69,72,76,73]
输出: [1,1,4,2,1,1,0,0]

示例 2:
输入: temperatures = [30,40,50,60]
输出: [1,1,1,0]

示例 3:
输入: temperatures = [30,60,90]
输出: [1,1,0]
 */
/**
 * 通过一个栈来模拟，就好了，debug一下
 */
class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Stack<Integer> stack = new Stack<>();
        //stack [0] [1] [2] []
        //ans [1,] [1,1,] [1,1,1,]
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

    public static void main(String[] args) {
        new Solution739().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }
}