package sort.test;

import sort.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] ints = {1, 2, 4, 3, 6, 5, 8, 7, 9, 0};
        IArraySort IArraySort = new BucketSort();
        IArraySort.sort(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+" ");
        }
    }
}
