package sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] ints = {5, 4, 3, 2, 1};
        quickSort(ints, 0, ints.length - 1);
        System.out.println(Arrays.toString(ints));
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        // 随机选择一个索引作为基准值
        Random rand = new Random();
        int pivotIndex = start + rand.nextInt(end - start + 1);
        // 将基准值交换到数组第一个位置
        swap(nums, start, pivotIndex);
        int pivot = nums[start];
        int left = start, right = end;
        while (left < right) {
            while (left < right && nums[right] > pivot) {
                right--;
            }
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
        // 将基准值交换到正确的位置
        swap(nums, start, left);
        // 递归地对基准值左右两边的数组进行快速排序
        quickSort(nums, start, left - 1);
        quickSort(nums, left + 1, end);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
