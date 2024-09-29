package interview.途虎养车二面;

import java.util.Arrays;

public class TwoSumBinarySearch {
    public static int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            //这个参数是
            //找的数组，从下标为fromIndex的数开始找，找到下标为toIndex的数字（左开右闭），目标值
            int index = Arrays.binarySearch(nums, i + 1, nums.length, complement);
            if (index > i) {
                return new int[]{nums[i], nums[index]};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result)); // 输出: [2, 7]
    }
}
