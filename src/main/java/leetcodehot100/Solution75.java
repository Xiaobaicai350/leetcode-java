package leetcodehot100;

/*
给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
必须在不使用库内置的 sort 函数的情况下解决这个问题。

示例 1：
输入：nums = [2,0,2,1,1,0]
输出：[0,0,1,1,2,2]
0,0,2,1,1,2

示例 2：
输入：nums = [2,0,1]
输出：[0,1,2]
 */

/**
 * 具体的思路就是，用左右指针分别直线数组的开始和数组的结尾，之后当遍历到0或者2的时候进行left和right下标的替换就可以了
 */
class Solution75 {
    public void sortColors(int[] nums) {
        //含义：left 指针的作用是标记当前已经排好序的 0 的最右边界。也就是说，在 left 指针左边的所有元素都为 0。
        int left = 0;
        //含义：right 指针的作用是标记当前已经排好序的 2 的最左边界。也就是说，在 right 指针右边的所有元素都为 2。
        int right = nums.length - 1;
        //mid 指针用于遍历数组，检查每个元素的值。
        int mid = 0;
        while (mid <= right) {
            if (nums[mid] == 0) {
                swap(nums, left, mid);
                left++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                //注意，这里 mid 指针不移动，因为交换后 nums[mid] 的值可能是 0 或 1，需要再次检查这个位置的值。
                swap(nums, mid, right);
                right--;
            }
        }
    }

    private void swap(int[] nums, int i, int left) {
        int temp = nums[i];
        nums[i] = nums[left];
        nums[left] = temp;
    }
}