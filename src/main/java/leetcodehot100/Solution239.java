package leetcodehot100;

import java.util.LinkedList;

/*
给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
返回 滑动窗口中的最大值 。
输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
输出：[3,3,5,5,6,7]
解释：
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 */
class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];//创建数组记录每个窗口的最大值
        LinkedList<Integer> queue = new LinkedList<>();//创建双相队列，队列里只存储下标
        for (int right = 0; right < nums.length; right++) {
            //如果队列不为空且当前元素大于等于队尾元素，则将队尾元素移除
            //直到队列为空或者当前元素小于新的队尾元素
            //保持队列单调递减：在遍历数组时，
            // 如果当前元素nums[right]大于等于队尾元素nums[queue.peekLast()]，则将队尾元素移除。为什么要移除呢，是因为就算这个移除元素存在，它也不会是最大值
            // 这样做是为了保持队列的单调递减性，确保队列头部的元素始终是当前窗口内的最大值。
            while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }
            //这个单调队列是从大到小排列的
            //注意这一步，存储的是元素的下标
            queue.addLast(right);
            int left = right - k + 1;
            //当队首元素的下标小于滑动窗口的left时
            //表示队首元素已经不在滑动窗口内，因此将其从队首移除
            if (queue.peekFirst() < left) {
                queue.removeFirst();
            }

            if (left >= 0) {//当left>=0时窗口形成，将队首元素的值赋给数组
                res[left] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}