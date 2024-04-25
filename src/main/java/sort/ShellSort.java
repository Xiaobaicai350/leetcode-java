package sort;

import sort.test.IArraySort;

/**
 * 希尔排序
 * <p>
 * 基本思想是：
 * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，
 * 待整个序列中的记录"基本有序"时，再对全体记录进行依次直接插入排序。
 * 比如分成5组，2组，1组进行排序，最后1组进行排序就会形成真正的顺序
 */
public class ShellSort implements IArraySort {
    @Override
    public void sort(int[] arr) throws Exception {
        // 获取数组长度
        int length = arr.length;
        // 定义一个临时变量，用于交换元素时暂存数据
        int temp;
        // 外层循环，初始步长为长度的一半，逐步减小步长，直到步长为1
        for (int step = length / 2; step >= 1; step /= 2) {
            // 内层循环，从步长开始，对每个元素进行插入排序
            for (int i = step; i < length; i++) {
                // 保存当前要插入的元素
                temp = arr[i];
                // 要比较的元素索引
                int j = i - step;
                // 插入排序的核心部分，找到适合插入的位置
                while (j >= 0 && temp < arr[j]) {
                    // 如果当前元素大于要插入的元素，向后移动
                    arr[j + step] = arr[j];
                    // 更新比较元素的索引
                    j -= step;
                }
                // 将当前元素插入到找到的位置
                arr[j + step] = temp;
            }
        }
    }
}
