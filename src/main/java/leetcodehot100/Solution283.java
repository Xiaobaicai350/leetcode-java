package leetcodehot100;

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