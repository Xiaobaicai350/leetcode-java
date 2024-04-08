package leetcodehot100;

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
                //如果是数组最后一个元素或者是数组
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