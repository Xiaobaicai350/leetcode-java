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

class Solution33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] <= nums[mid]) {//需要注意这里还有一个=
                //进到这里说明mid左边是有序的
                //1.最左边小于目标大小，说明从left到目标是递增的，如果不递增，说明中间存在旋转位置。
                //2.中间位置小于目标大小，说明就是在左边，需要修改right
                if (nums[left] <= target && nums[mid] > target) {
                    //进到这里说明target在mid左边
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //进到这里说明mid右边是有序的
                if (nums[right] >= target && nums[mid] < target) {
                    //说明target在mid的右边
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new Solution33().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);
    }
}
