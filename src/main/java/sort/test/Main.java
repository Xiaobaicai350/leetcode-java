package sort.test;

import sort.BubbleSort;
import sort.ShellSort;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] ints = {1, 2, 4, 3, 6, 5, 8, 7, 9, 0};
        IArraySort IArraySort = new ShellSort();
        IArraySort.sort(ints);
    }
}
