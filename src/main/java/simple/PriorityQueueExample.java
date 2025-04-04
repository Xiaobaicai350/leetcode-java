package simple;

import java.util.PriorityQueue;

/*
优先队列（Priority Queue）是一种特殊的队列，它与普通队列不同，普通队列遵循先进先出（FIFO）的原则，即最先进入队列的元素最先出队；
而优先队列中的元素出队顺序是由元素的优先级决定的，优先级高的元素先出队。
优先队列的特点
元素具有优先级：每个元素都有一个与之关联的优先级，这个优先级决定了元素在队列中的顺序。
动态调整：当新元素加入队列或元素被移除时，队列会自动调整元素的顺序，以确保优先级高的元素始终位于队列的前面。
出队列先出数字低的数
 */
public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(3);
        priorityQueue.add(1);
        priorityQueue.add(2);

        //现在优先队列里面的元素是：1, 2, 3
        System.out.println(priorityQueue.poll()); // 输出: 1
        System.out.println(priorityQueue.peek()); // 输出: 2
    }
}