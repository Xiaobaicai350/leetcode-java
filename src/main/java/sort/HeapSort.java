package sort;

import sort.test.IArraySort;


public class HeapSort implements IArraySort {

    @Override
    public void sort(int[] arr) throws Exception {
        // 获取数组的长度
        int len = arr.length;
        // 构建最大堆
        buildMaxHeap(arr, len);
        // 排序过程，将堆顶元素（最大值）与堆底元素交换，然后重新调整堆
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i); // 交换堆顶和堆底元素
            len--; // 减小堆的大小，排除已排序的元素
            heapify(arr, 0, len); // 从堆顶开始调整堆
        }
    }

    // 构建最大堆
    private void buildMaxHeap(int[] arr, int len) {
        // 从最后一个非叶子节点开始，向上逐个节点进行堆化
        for (int i = len / 2; i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    // 堆化过程，确保堆的属性
    private void heapify(int[] arr, int i, int len) {
        // 计算左右子节点的索引
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i; // 假设当前节点是最大的

        // 如果左子节点存在且大于当前节点，更新最大节点的索引
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        // 如果右子节点存在且大于当前最大节点，更新最大节点的索引
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        // 如果最大节点的索引不是当前节点的索引，说明子节点中有更大的值
        if (largest != i) {
            swap(arr, i, largest); // 交换当前节点和最大子节点的值
            heapify(arr, largest, len); // 递归地对受影响的子节点进行堆化
        }
    }

    // 交换数组中两个元素的位置
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
