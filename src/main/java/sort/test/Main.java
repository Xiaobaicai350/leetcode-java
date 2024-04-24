package sort.test;

import sort.BubbleSort;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] ints = {1, 2, 4, 3, 6, 5, 8, 7, 9};
        IArraySort IArraySort = new BubbleSort();
        IArraySort.sort(ints);
    }
}
