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

    //快排的思想其实就是，一趟递归把小于等于基准的元素放在基准左边，大于基准的元素放在基准右边，然后递归对左右两边进行排序。
    private static void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        // 随机选择一个索引作为基准值
        Random rand = new Random();
        //选择这个范围内的随机一个元素
        int pivotIndex = start + rand.nextInt(end - start + 1);
        //int pivotIndex = start;//也可以这样

        // 将基准值交换到数组第一个位置
        swap(nums, start, pivotIndex);
        int pivot = nums[start];//基准值
        int left = start;//遍历的下标
        int right = end;//遍历的下标
        while (left < right) {
            while (left < right && nums[right] > pivot) {//从右往左遍历，找到第一个小于等于基准值的元素
                right--;
            }
            while (left < right && nums[left] <= pivot) {//从左往右遍历，找到第一个大于基准值的元素
                left++;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
        // 将基准值交换到正确的位置
        swap(nums, start, left);//现在left==right，现在left位置的元素是小于等于基准的，因为上面right的位置是第一个小于等于基准值的元素，left是第一个大于基准值，但是left和right交换了；
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
