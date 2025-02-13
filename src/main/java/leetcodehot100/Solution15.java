package leetcodehot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
请你返回所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。

示例 1：
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
解释：
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。

示例 2：
输入：nums = [0,1,1]
输出：[]
解释：唯一可能的三元组和不为 0 。

示例 3：
输入：nums = [0,0,0]
输出：[[0,0,0]]
解释：唯一可能的三元组和为 0 。
 */

/*
为了保证结果集中没有重复的解，主要采取了以下两个策略：
跳过重复的第一个数：
    在遍历数组时，如果当前数与前一个数相同（即 nums[i] == nums[i - 1]），则跳过当前数。这是因为如果当前数与前一个数相同，
    那么以当前数为第一个数的所有可能的三元组都已经在前一个数的遍历中被考虑过了，继续考虑当前数只会产生重复的解。
跳过重复的第二个数和第三个数：
    当找到一个满足条件的三元组（即 nums[i] + nums[left] + nums[right] == 0）时，需要跳过重复的第二个数和第三个数。这是通过两个 while 循环来实现的：
    while (right > left && nums[right] == nums[right - 1]) right--;：这个循环会跳过所有与当前 right 指针指向的数相同的数，确保 right 指针指向的数是唯一的。
    while (right > left && nums[left] == nums[left + 1]) left++;：这个循环会跳过所有与当前 left 指针指向的数相同的数，确保 left 指针指向的数是唯一的
 */
/**
 * -4 -1 -1 0 1 2
 */
class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 结果集
        List<List<Integer>> result = new ArrayList<>();
        // 对该数组排序
        Arrays.sort(nums);
        // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
        // 这段话去掉也不影响结果，只是一个优化的方案
        if (nums[0] > 0) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            // 由于是排序后的，所以为了去除重复解，从第二个数和前一个数开始比较，若相同就跳过（注意，这个是必须存在的，因为i值只能唯一，如果重复的话肯定会生成重复的解）
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //定义双指针，一个指向当前位置的后一个位置，一个指向数组最后的位置
            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {//如果大于0，说明大了，应该让右指针往左移动
                    right--;
                } else if (sum < 0) {//如果小于0，说明小了，应该让左指针向右移动
                    left++;
                } else {
                    // 把这三个数放进集合中
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (right > left && nums[right] == nums[right - 1]) {//跳过重复的结果
                        right--;
                    }
                    while (right > left && nums[left] == nums[left + 1]) {//跳过重复的结果
                        left++;
                    }
                    //继续进行遍历，看剩下的数组还有没有合适的解
                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}