package sort;

import sort.test.IArraySort;

import java.util.Arrays;

/*
基数排序 vs 计数排序 vs 桶排序
基数排序：根据键值的每位数字来分配桶；
计数排序：每个桶只存储单一键值；
桶排序：每个桶存储一定范围的数值；
 */
/**
 * 基数排序算法
 * 该算法根据数字的每一位进行排序，从最低位开始，依次向最高位进行。
 * 可以当作先把最个位的排序，然后再把十位的排序...依次
 */
public class RadixSort implements IArraySort {

    @Override
    public void sort(int[] arr) throws Exception {
        // 获取最高位数，即确定需要进行排序的轮数
        int maxDigit = getMaxDigit(arr);
        // 执行基数排序
        radixSort(arr, maxDigit);
    }
    /**
     * 基数排序主方法
     * 对数组arr进行基数排序。
     */
    private void radixSort(int[] arr, int maxDigit) {
        int mod = 10;   // mod用于确定当前位的值（个位、十位、百位...）
        int dev = 1;    // dev为10的幂，用于确定比较的位数（个位、十位、百位...）

        // 从个位开始，对每一位进行排序
        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // 考虑负数的情况，所以队列数扩展一倍，[0-9]对应负数，[10-19]对应正数 (bucket + 10)
            int[][] counter = new int[mod * 2][0];

            // 分配数组中的每个值到对应的桶中
            for (int j = 0; j < arr.length; j++) {
                int bucket = ((arr[j] % mod) / dev) + mod;
                counter[bucket] = arrayAppend(counter[bucket], arr[j]);
            }

            // 收集桶中的值，并放回原数组
            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
            }
        }
    }
    /**
     * 这个方法用于确定数组中最大数的位数，以便确定排序的轮数。
     */
    private int getMaxDigit(int[] arr) {
        // 获取数组中的最大值
        int maxValue = getMaxValue(arr);
        // 计算最大值的位数
        return getNumLength(maxValue);
    }

    /**
     * 获取最大值
     * 遍历数组，找到最大的数值。
     */
    private int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    /**
     * 计算数字的位数
     * 通过不断除以10并计数，来确定一个数字的位数。
     */
    protected int getNumLength(long num) {
        if (num == 0) {
            return 1; // 0的位数是1
        }
        int length = 0;
        while (num != 0) {
            length++;    // 位数加1
            num /= 10;   // num除以10，移动到下一位
        }
        return length;
    }

    /**
     * 动态扩容数组并添加新值
     * 这个方法用于向数组中添加一个新值，并动态扩容数组。
     */
    private int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1); // 扩容数组
        arr[arr.length - 1] = value;             // 添加新值
        return arr;
    }
}
