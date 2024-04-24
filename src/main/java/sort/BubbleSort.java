package sort;

import sort.test.IArraySort;

public class BubbleSort implements IArraySort {
    /**
     * 基础版本的冒泡排序
     *
     * @param arr
     * @return
     */
    @Override
    public int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                //注意这里比较的只有j
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }
}