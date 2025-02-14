package leetcodehot100;

/*
给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
如果数组中不存在目标值 target，返回 [-1, -1]。
你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。

示例 1：
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]

示例 2：
输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]

示例 3：
输入：nums = [], target = 0
输出：[-1,-1]
 */
class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int firstIndex = searchFirst(nums, target);
        int lastIndex = searchLast(nums, target);
        return new int[]{firstIndex, lastIndex};
    }

    private int searchFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                //两个方法只有这里不一样。
                if (mid == 0 || nums[mid - 1] != nums[mid]) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int searchLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                //两个方法只有这里不一样。
                //到这里说明是target==nums[mid]了已经，但是不确定是不是边界，所以需要验证边界。
                //如果是数组最后一个元素或者是数组右边还有跟这个元素相等的值。
                if (mid == nums.length - 1 || nums[mid] != nums[mid + 1]) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}