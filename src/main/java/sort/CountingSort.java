package sort;

import sort.test.IArraySort;

/*
算法的步骤如下：
（1）找出待排序的数组中最大元素
（2）统计数组中每个值为i的元素出现的次数，存入数组C的第i项
（3）对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）
（4）反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1
 */
public class CountingSort implements IArraySort {

    @Override
    public void sort(int[] arr) throws Exception {
        // 获取数组中的最大值
        int maxValue = getMaxValue(arr);
        // 使用计数排序对数组进行排序
        countingSort(arr, maxValue);
    }

    //计数排序实现
    private void countingSort(int[] arr, int maxValue) {
        // 初始化计数数组，长度为最大值加一
        int[] bucket = new int[maxValue + 1];

        // 计算每个元素的频率
        for (int value : arr) {
            bucket[value]++;
        }

        // 根据计数数组的值重排原数组
        int sortedIndex = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                arr[sortedIndex++] = i;
                bucket[i]--;
            }
        }
    }

    //找到数组中的最大值并且返回
    private int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

}
