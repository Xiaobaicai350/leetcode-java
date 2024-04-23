package leetcodehot100;

import java.util.HashMap;
import java.util.Map;

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        // 创建一个哈希表，用于存储数组中的数字及其对应的索引
        Map<Integer, Integer> hashtable = new HashMap<>();
        // 遍历数组中的每个元素
        for (int i = 0; i < nums.length; ++i) {
            // 计算目标值与当前元素的差值
            int complement = target - nums[i];
            // 如果哈希表中存在与差值对应的元素，则找到了一对解
            if (hashtable.containsKey(complement)) {
                // 返回这两个元素的索引
                int index = hashtable.get(complement);
                return new int[]{index, i};
            } else {
                // 如果哈希表中没有差值对应的元素，则将当前元素及其索引添加到哈希表中
                hashtable.put(nums[i], i);
            }
        }
        // 如果没有找到解，返回一个空数组
        return new int[0];
    }
}