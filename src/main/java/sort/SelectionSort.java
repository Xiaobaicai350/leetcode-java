package sort;

import sort.test.IArraySort;

import java.util.Arrays;

/**
 * 选择排序
 * 算法步骤：
 * 从剩下的数组中找到最小的放在前部
 */
public class SelectionSort implements IArraySort {

    @Override
    public void sort(int[] arr) throws Exception {
        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            //记录最小值的下标
            int min = i;
            // 每轮需要比较的次数 N-i-1
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }
            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }
}