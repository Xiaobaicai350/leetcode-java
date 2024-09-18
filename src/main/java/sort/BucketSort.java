package sort;

import java.util.Arrays;

/**
 * 桶排序算法
 * 原理是将一个范围内的数据分配到不同的桶中，然后对每个桶进行排序，最后合并结果。
 */
public class BucketSort implements IArraySort {

    // 使用插入排序来对桶内的数据进行排序
    private static final InsertSort insertSort = new InsertSort();

    @Override
    public void sort(int[] arr) throws Exception {
        bucketSort(arr, 10);
    }

    private void bucketSort(int[] arr, int bucketSize) throws Exception {
        // 找到数组中的最小值和最大值
        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }

        // 计算桶的数量
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][0];

        // 将数组中的值分配到桶中
        for (int i = 0; i < arr.length; i++) {
            int index = (arr[i] - minValue) / bucketSize;
            buckets[index] = arrAppend(buckets[index], arr[i]);
        }

        // 对每个桶进行排序并合并结果
        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            // 使用插入排序对桶中的元素进行排序
            insertSort.sort(bucket);
            //按照顺序放到原数组中
            for (int value : bucket) {
                arr[arrIndex++] = value;
            }
        }
    }

    /**
     * 动态扩容数组并添加新值，跟Go中的append函数类似
     */
    private int[] arrAppend(int[] arr, int value) {
        // 复制数组并增加一个元素的空间
        arr = Arrays.copyOf(arr, arr.length + 1);
        // 添加新值
        arr[arr.length - 1] = value;
        return arr;
    }

}
