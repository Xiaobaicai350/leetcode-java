package leetcodehot100;

import java.util.PriorityQueue;

/**
 * 小顶堆的特点：
 * 堆中的每个节点的值都小于或等于其子节点的值。
 * 堆是一个完全二叉树，即除了最底层外，其他层的节点都被完全填满，且最底层的节点都依次从左到右填入。
 * 堆中的根节点（顶部节点）是最小的元素。
 */
class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        // 创建一个小顶堆，小顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // 遍历数组中的每个元素
        for (int num : nums) {
            if (heap.size() < k) { // 如果堆的大小小于k，则将元素添加到堆中
                heap.add(num);
            } else if (heap.peek() < num) {//到这里说明堆里面已经有k个元素了，放不下了，说明需要换元素了
                // 如果堆的顶部元素小于当前元素，则将堆顶元素弹出，再将当前元素添加到堆中
                heap.poll();
                heap.add(num);
            }
        }

        //输入: [3,2,1,5,6,4], k = 2  输出5
        //到这里的时候 堆里面存储的是 5，6 堆顶是5，直接返回5就可以了。
        // 返回堆顶元素，即第k大的元素，因为堆里面就k个元素，而小顶堆的堆顶又是这里面最小的，所以直接返回堆顶就行了
        return heap.poll();
    }
}