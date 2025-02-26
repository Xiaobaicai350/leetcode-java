package leetcodehot100;

/*
给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案
输入：nums = [3,4,-1,1]
输出：2
解释：1 在数组中，但 2 没有。
 */
class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 交换nums[i]和nums[nums[i]-1]的位置.
            //    - 例如，值为1的元素应该在索引0处，值为2的元素应该在索引1处，以此类推。
            while (nums[i] >= 1 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        //再次遍历数组，检查每个索引`i`上的元素是否等于`i + 1`。
        //如果不等，则说明`i + 1`是数组中缺失的第一个正整数，直接返回`i + 1`。
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // 如果到这里还没有返回，说明缺失的是最后一位
        return n + 1;
    }

    // 交换函数
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}