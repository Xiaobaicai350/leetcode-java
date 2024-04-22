package leetcodehot100;

/*
 nums = [2,0,2,1,1,0]
 输出：[0,0,1,1,2,2]
 */

/**
 * 使用整数 0  1  2 分别表示红色、白色、蓝色。
 * 具体的思路就是，用左右指针分别直线数组的开始和数组的结尾，之后当遍历到0或者2的时候进行left和right下标的替换就可以了
 */
class Solution75 {
    public void sortColors(int[] nums) {
        //定义左右指针
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
            } else if (nums[i] == 2) {
                swap(nums, i, right);
                right--;
                //因为for循环内部都i了，但是我们不让他加，只有在!=2的时候再加
                i--;
            }
        }
    }

    private void swap(int[] nums, int i, int left) {
        int temp = nums[i];
        nums[i] = nums[left];
        nums[left] = temp;
    }
}