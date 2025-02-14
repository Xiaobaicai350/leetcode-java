package leetcodehot100;

/*
整数数组 nums 按升序排列，数组中的值 互不相同 。
在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。

示例 1：
输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4

示例 2：
输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1

示例 3：
输入：nums = [1], target = 0
输出：-1
 */

/**
 * 其实还是二分查找。
 * 只是再比较的时候再加一个判断就可以拉
 */
class Solution33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] <= nums[mid]) { // 如果左边界比中间的小的话，说明左边是没翻转的，也就是说左边是连续递增的
                // 如果target比中间这个小，并且target在左边，说明target就在左边这部分
                if (target < nums[mid] && nums[left] <= target) {
                    //所以更改右指针。
                    right = mid - 1;
                } else { // 否则就没在，说明在右边
                    left = mid + 1;
                }
            } else {// 否则说明右边是没翻转的，也就是右边是连续递增的
                //这个跟上面的同理。
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
