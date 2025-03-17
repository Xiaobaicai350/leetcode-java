package leetcodehot100;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。

示例 1:
输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]

示例 2:
输入: nums = [1], k = 1
输出: [1]
 */
class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        //key为数组元素值,val为对应出现次数
        Map<Integer, Integer> map = new HashMap<>();
        //把数组的对应值和出现的次数都放到map中
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //里面是一个一个的数组，相当于二维数组，下标为0的是key，下标为1的是value
        //创建小顶堆，堆顶最小
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((pair1, pair2) -> pair1[1] - pair2[1]);        //遍历map，取出entry
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //小顶堆元素个数小于k个时直接加入到堆里
            if (minHeap.size() < k) {
                minHeap.add(new int[]{entry.getKey(), entry.getValue()});
            } else {//否则就是堆里的元素个数多了
                //判断现在遍历的这个的value和堆顶的哪个大,堆顶的是最小的
                if (entry.getValue() > minHeap.peek()[1]) {
                    //如果进来说明比堆顶的大，需要把堆顶的弹出，然后把这个entry添加进去
                    minHeap.poll();
                    minHeap.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {//依次弹出小顶堆,先弹出的是堆的根,出现次数少,后面弹出的出现次数多
            ans[i] = minHeap.poll()[0];
        }
        return ans;
    }
}