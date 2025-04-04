package leetcodehot100;

import java.lang.reflect.Array;
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
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //去除重复的结果
            if (i > 0 && nums[i - 1] == nums[i]) {
                i++;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    // 把这三个数放进集合中
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    while (left<right&&nums[left]==nums[left+1]){
                        left++;
                    }
                    while (left<right&&nums[right]==nums[right-1]){
                        right--;
                    }
                    //继续进行遍历，看剩下的数组还有没有合适的解
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                }else {
                    right--;
                }
            }
        }
        return res;

    }
}