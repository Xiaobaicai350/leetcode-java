package leetcodehot100;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。
 */
class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        //key为数组元素值,val为对应出现次数
        Map<Integer, Integer> map = new HashMap<>();
        //把数组的对应值和出现的次数都放到map中
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //用优先队列表示小顶堆
        /*
          小顶堆的特点：
          堆中的每个节点的值都小于或等于其子节点的值。
          堆是一个完全二叉树，即除了最底层外，其他层的节点都被完全填满，且最底层的节点都依次从左到右填入。
          堆中的根节点（顶部节点）是最小的元素。
         */
        //队列里面是一个一个的数组，相当于二维数组，下标为0的是key，下标为1的是value
        PriorityQueue<int[]> heap = new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);
        //遍历map，取出entry
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //小顶堆元素个数小于k个时直接加入到堆里
            if (heap.size() < k) {
                heap.add(new int[]{entry.getKey(), entry.getValue()});
            } else {//否则就是堆个数多了
                //判断现在遍历的这个的value和堆顶的哪个大,堆顶的是最小的
                if (entry.getValue() > heap.peek()[1]) {
                    //如果进来说明比堆顶的大，需要把堆顶的弹出，然后把这个entry添加进去
                    heap.poll();
                    heap.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {//依次弹出小顶堆,先弹出的是堆的根,出现次数少,后面弹出的出现次数多
            ans[i] = heap.poll()[0];
        }
        return ans;
    }
}