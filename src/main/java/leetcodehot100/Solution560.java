package leetcodehot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
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

