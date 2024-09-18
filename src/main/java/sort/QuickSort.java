package sort;

/**
 * 快速排序的名字起的是简单粗暴，因为一听到这个名字你就知道它存在的意义，就是快，而且效率高！它是处理大数据最快的排序算法之一了
 */
/*
以下是快速排序的基本步骤：
选择基准元素：从数组中选择一个元素作为基准（通常选择第一个元素、最后一个元素或者随机选择）。
划分：将数组中小于基准元素的元素移到基准元素的左边，大于基准元素的元素移到右边。通常使用两个指针来实现这一步骤，一个从数组的左端开始，一个从右端开始，然后它们向中间移动，直到它们相遇。
递归排序：递归地对划分后的左右两个子数组进行排序。
合并：无需合并，因为排序是原地进行的。
递归终止条件：当子数组的大小为0或1时，递归停止。
 */
public class QuickSort implements IArraySort {
    @Override
    public void sort(int[] arr) throws Exception {
        quickSort(arr, 0, arr.length - 1); // 调用递归排序方法
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1); // 对分区左侧的数组进行快速排序
            quickSort(arr, partitionIndex + 1, right); // 对分区右侧的数组进行快速排序
        }
    }

    //这个方法会对基准值的两边进行划分，返回的是基准值的最终位置
    private int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）为最左边的那个元素
        int pivot = left;
        //最左边的下一个元素的下标
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            //如果
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1); // 将基准值放置到正确的位置，也就是index-1的位置，因为index左边都是比他小的
        return pivot; // 返回基准值的最终位置
    }

    //交换数组中的两个元素的位置
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
