package writtenExamination.小米笔试1012;

import java.util.Arrays;
import java.util.Scanner;

/*
5
1 -2 3 -4 -5
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        bubbleSort(nums);
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                nums[i + 1] = -nums[i + 1];
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += nums[i];
        }
        System.out.println(res);
    }

    private static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (Math.abs(nums[j]) < Math.abs(nums[j+1])) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

}

