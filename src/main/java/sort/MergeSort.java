package sort;

/*
算法步骤:
1.申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
2.设定两个指针，最初位置分别为两个已经排序序列的起始位置；
3.比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
4.重复步骤 3 直到某一指针达到序列尾；
5.将另一序列剩下的所有元素直接复制到合并序列尾。
 */
public class MergeSort implements IArraySort {

    @Override
    public void sort(int[] arr) throws Exception {
        if (arr == null || arr.length < 2) {
            return; // 如果数组为空或只有一个元素，无需排序，直接返回
        }
        int[] temp = new int[arr.length]; // 创建一个临时数组，用于合并排序时的暂存
        internalSort(arr, temp, 0, arr.length - 1); // 调用递归排序方法
    }

    private void internalSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // 计算中点，进行分割
            internalSort(arr, temp, left, mid); // 递归地对左半部分进行排序
            internalSort(arr, temp, mid + 1, right); // 递归地对右半部分进行排序
            merge(arr, temp, left, mid, right); // 合并两个有序的部分
        }
    }

    private void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // 将待合并的数组部分复制到临时数组中
        System.arraycopy(arr, left, temp, left, right - left + 1);
        int i = left; // 初始化左半部分的起始索引
        int j = mid + 1; // 初始化右半部分的起始索引
        int k = left; // 初始化合并后数组的起始索引
        // 合并两个有序数组
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++]; // 如果左边元素小于等于右边元素，取左边元素
            } else {
                arr[k++] = temp[j++]; // 如果左边元素大于右边元素，取右边元素
            }
        }
        // 如果左半部分还有剩余元素，将它们复制到原数组中
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
        // 如果右半部分还有剩余元素，将它们复制到原数组中
        while (j <= right) {
            arr[k++] = temp[j++];
        }
    }
}

