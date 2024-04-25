package leetcodehot100;

import java.util.HashSet;
import java.util.Set;

/**
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
class Solution128 {
    public int longestConsecutive(int[] nums) {
        // 创建一个HashSet来存储数组中的所有数字，以便快速查找
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;  // 用于存储最长连续序列的长度
        // 遍历HashSet中的每个元素
        for (int num : set) {
            // 只有当当前数字不是某个序列的开始时，能进入这个循环
            // 即，如果num-1也在集合中，那么num不是序列的开始
            if (!set.contains(num - 1)) {
                //进来的都是有可能成为开始的数字
                int currentNum = num;  // 当前数字
                int currentRes = 1; // 当前连续序列的长度初始化为1
                // 检查当前数字的下一个数字是否存在，即num+1是否在集合中
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;  // 移动到下一个数字
                    currentRes += 1;  // 增加当前连续序列的长度
                }
                // 更新最长连续序列的长度
                res = Math.max(res, currentRes);
            }
        }
        // 返回找到的最长连续序列的长度
        return res;
    }
}
