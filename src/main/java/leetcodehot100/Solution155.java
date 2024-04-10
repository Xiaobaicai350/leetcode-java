package leetcodehot100;

import java.util.Stack;

public class Solution155 {
}

class MinStack {
    //存储值的栈
    private Stack<Integer> stack;
    //辅助栈
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        //初始化一个很大很大的值，确保第一个数字一定会比他小
        //这就意味着，minStack里面的值永远比stack多一个
        minStack.push(Integer.MAX_VALUE);
    }

    // 压栈操作
    public void push(int val) {
        //把值添加到普通栈中
        stack.push(val);
        //得到辅助栈栈顶的值作为top

        int top = minStack.peek();
        //比较当前值和辅助栈栈顶的值，得到最小值加入到辅助栈中

        minStack.push(Math.min(val, top));
    }

    //弹栈操作
    public void pop() {
        //下面这两行其实是把两个栈都截取最后一个位置的，相当于两个栈都弹栈了
        stack.pop();
        minStack.pop();
    }

    // 拿到栈顶的元素值
    public int top() {
        return stack.peek();
    }

    // 拿到当前栈中的最小值
    public int getMin() {
        return minStack.peek();
    }
}