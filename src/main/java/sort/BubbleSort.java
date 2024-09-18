package sort;

/**
 * 冒泡排序
 */
public class BubbleSort implements IArraySort {
    @Override
    public void sort(int[] arr) {
        //从第二个数字开始遍历，也就是说需要遍历len-1趟
        for (int i = 1; i < arr.length; i++) {
            //每一趟需要比较多少次。比如说十个数：第1趟需要遍历9次，第2趟要遍历8次。
            for (int j = 0; j < arr.length - i; j++) {
                //注意这里比较的只有j
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}