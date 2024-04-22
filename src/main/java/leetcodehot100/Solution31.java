package leetcodehot100;

class Solution31 {
    public void nextPermutation(int[] nums) {
        // 从数组的末尾开始向前查找
        for (int i = nums.length - 1; i >= 0; i--) {
            // 再次从数组的末尾开始向前查找，寻找第一个比nums[i]大的数
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[i] < nums[j]) {
                    // 交换nums[i]和nums[j]
                    swap(nums, i, j);
                    // 对i+1到数组末尾的部分进行冒泡排序
                    bubbleSort(nums, i + 1, nums.length);
                    return; // 完成一次排列，返回
                }
            }
        }
        // 如果没有找到可以交换的数，说明整个数组是逆序的，即最大的排列
        // 对整个数组进行冒泡排序，得到最小的排列，即升序排列
        bubbleSort(nums, 0, nums.length);
    }

    // 用于交换数组中的两个元素
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 冒泡排序，用于对数组的一部分进行排序
    private void bubbleSort(int[] arr, int start, int end) {
        for (int i = start; i < end - 1; i++) {
            for (int j = start; j < end - i - 1 + start; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 如果当前元素大于下一个元素，交换它们
                    swap(arr, j, j + 1);
                }
            }
        }
    }
}