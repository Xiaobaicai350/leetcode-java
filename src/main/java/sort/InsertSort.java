package sort;

import sort.test.IArraySort;

/**
 * 插入排序
 * 工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 */
public class InsertSort implements IArraySort {
    @Override
    public int[] sort(int[] arr) throws Exception {
        // 从下标为1的元素开始选择合适的位置插入
        for (int i = 1; i < arr.length; i++) {
            // 记录要插入的数据
            int tmp = arr[i];
            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            //如果j变化了，说明前面有比他大的元素，要交换了，如果没变的话，就不用交换
            if (j != i) {
                arr[j] = tmp;
            }
        }
        return arr;
    }
}