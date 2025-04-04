package leetcodehot100;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution232 {
}

/*用栈实现队列*/
/*
    思路
    将一个栈当作输入栈，用于压入push传入的数据；
    另一个栈当作输出栈，用于pop和peek操作。
    每次 pop 或 peek 时，若输出栈为空则将输入栈的全部数据依次弹出并压入输出栈，这样输出栈从栈顶往栈底的顺序就是队列从队首往队尾的顺序。
*/
class MyQueue {
    // inStack 用于模拟队列的入队操作。
    Deque<Integer> inStack;
    // outStack 用于模拟队列的出队操作。
    Deque<Integer> outStack;

    public MyQueue() {
        inStack = new ArrayDeque<Integer>();
        outStack = new ArrayDeque<Integer>();
    }

    public void push(int x) {
        //只压入in栈
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
    //把in栈中的数据加入到out栈中
    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}



