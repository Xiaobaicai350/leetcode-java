package leetcodehot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            // 由于是排序后的，所以为了去除重复解，从第二个数和前一个数开始比较，若相同就跳过
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
                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}