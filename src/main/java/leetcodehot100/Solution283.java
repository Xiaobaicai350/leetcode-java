package leetcodehot100;

/*
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。请注意 ，必须在不复制数组的情况下原地对数组进行操作。
示例 1:
输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]
示例 2:
输入: nums = [0]
输出: [0]
 */
class Solution283 {
    public void moveZeroes(int[] nums) {
        int i = 0;
        // 把i指向0
        while (i < nums.length && nums[i] != 0) {
            i++;
        }
        // 从i的下一个开始循环，这时
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] != 0) {
                //到这里说明是nums[j]不是0
                // 之后直到把0交换到结尾
                swap(nums, i, j);
                // 交换之后i也需要++
                i++;
            }
        }
    }

    // 交换函数
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}