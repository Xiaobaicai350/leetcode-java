package simple;

import java.util.LinkedList;
import java.util.Queue;

//队列是一种先进先出（FIFO）的数据结构。
public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue.poll()); // 输出: 1
        System.out.println(queue.peek()); // 输出: 2
    }
}