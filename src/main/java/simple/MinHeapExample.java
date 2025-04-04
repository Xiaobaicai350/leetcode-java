package simple;

import java.util.PriorityQueue;

/*
小顶堆（Min-Heap）
小顶堆是一种完全二叉树，堆顶最小
在 Java 中，可以使用 PriorityQueue 来实现小顶堆。
 */
public class MinHeapExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(3);
        minHeap.add(1);
        minHeap.add(2);

        System.out.println(minHeap.poll()); // 输出: 1
        System.out.println(minHeap.peek()); // 输出: 2
    }
}