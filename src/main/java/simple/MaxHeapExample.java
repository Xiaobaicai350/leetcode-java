package simple;

import java.util.PriorityQueue;

//用优先队列实现大顶堆
//堆顶最大
public class MaxHeapExample {
    public static void main(String[] args) {
        // 创建一个大顶堆，通过自定义比较器实现
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // 向大顶堆中添加元素
        maxHeap.add(3);
        maxHeap.add(1);
        maxHeap.add(2);

        // 输出堆顶元素（最大元素）
        System.out.println(maxHeap.poll()); // 输出: 3
        // 查看堆顶元素（不删除）
        System.out.println(maxHeap.peek()); // 输出: 2
    }
}