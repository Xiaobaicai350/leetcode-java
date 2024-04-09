package leetcodehot100;

/**
 * https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/solutions/698479/xun-zhao-xuan-zhuan-pai-xu-shu-zu-zhong-5irwp/?envType=study-plan-v2&envId=top-100-liked
 * 其实就是二分查找，结合题解中的图会更好理解一些
 */
class Solution153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] < nums[right]) { // 说明右边是正常的，可以直接忽略了
                right = mid;
            } else { // 说明右边是不正常的，左侧是正常的,因为只有一侧是正常的
                // 表明nums[mid]是最小值左侧的元素，所以可以直接忽略左半部分，这里注意是+1
                left = mid + 1;
            }
        }
        // 到这里说明left == right了，所以返回哪个都可以了
        return nums[left];
    }
}
