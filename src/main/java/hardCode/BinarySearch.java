package hardCode;

public class BinarySearch {
    public static int commonBinarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int middle = 0;            //定义middle
        while (low <= high) {
            //middle = low + (high - low) / 2;//跟下方等价 防止溢出
            middle = (low + high) / 2;
            if (arr[middle] > key) {
                //比关键字大则关键字在左区域
                high = middle - 1;
            } else if (arr[middle] < key) {
                //比关键字小则关键字在右区域
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;        //最后仍然没有找到，则返回-1
    }
}
