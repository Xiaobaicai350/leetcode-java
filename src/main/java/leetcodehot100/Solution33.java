package leetcodehot100;

/**
 * 其实还是二分查找。
 * 只是再比较的时候再加一个判断就可以拉
 */
class Solution33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) /2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] <= nums[mid]) { // 如果左边界比中间的小的话，说明左边是没翻转的，也就是说左边是连续递增的
                // 如果target在左边这部分，并且target比中间这个小，说target就在左边这部分
                if (nums[left] <= target && target < nums[mid]) {
                    //所以更改右指针。
                    right = mid - 1;
                } else { // 否则就没在，说明在右边
                    left = mid + 1;
                }
            } else {
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
