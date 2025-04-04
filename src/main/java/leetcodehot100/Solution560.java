package leetcodehot100;

import java.util.HashMap;
import java.util.Map;

/*
给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
子数组是数组中元素的连续非空序列。

示例 1：
输入：nums = [1,1,1], k = 2
输出：2

示例 2：
输入：nums = [1,2,3], k = 3
输出：2
 */
/**
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 * 注意，这个必须是连续的！
 * 为什么要用前缀和呢：因为题目中要求是是子数组（子数组是数组中元素的 连续 非空序列。）
 * 所以可以用sum-k，算出某一段连续的地方是哪里，然后再加上就可以了。
 * sum=1的时候，map{[0,1]} 1-3=-2 没有
 * sum=3的时候 map{[0,1][1,1]} 3-3=0 有
 * sum=6的时候 map{[0,1][1,1][3,1]} 6-3=3 有
 */
class Solution560 {
    public  int subarraySum(int[] nums, int k) {
        // 用来表示从nums[0]...到nums[i]的前缀和
        int sum = 0;
        // 记录总数
        int count = 0;
        // key是前缀和，value是前缀和出现了多少次
        Map<Integer, Integer> map = new HashMap<>();
        // 前缀和为0的情况，也就是什么都没有的情况只有1次
        map.put(0, 1);
        for (int num : nums) {
            // 更新前缀和
            sum += num;
            // 如果存在前缀和为sum-k，就把count加上
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            // 将当前前缀和的出现次数加1
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        // 返回满足条件的子数组数量
        return count;
    }
}

