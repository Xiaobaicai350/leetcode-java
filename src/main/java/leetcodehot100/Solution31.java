package leetcodehot100;

import java.util.Arrays;

public class Solution31 {
    public void nextPermutation(int[] nums) {
        //数组倒数第二个下标
        int i = nums.length - 2;
        // 从数组的末尾开始向前查找，找到第一个递减的元素
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        //现在的情况是：nums[i]<nums[i+1]
        // 从数组末尾找到第一个大于nums[i]的元素并交换
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }

        // 反转i之后的所有元素，以得到下一个排列(由于所有的数字都是这样的出来的，记住就可以了)
        reverse(nums, i + 1, nums.length - 1);
    }

    // 用于交换数组中的两个元素
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 反转数组的一部分
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        new Solution31().nextPermutation(new int[]{1,2,4,3});
    }
}

