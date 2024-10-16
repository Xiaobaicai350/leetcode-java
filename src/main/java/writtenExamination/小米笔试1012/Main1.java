package writtenExamination.小米笔试1012;

import java.util.Arrays;
import java.util.Scanner;

/*
5
1 -2 3 -4 -5
 */
public class Main1 {
    public static void main1(String[] args) {
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
                if (Math.abs(nums[j]) < Math.abs(nums[j + 1])) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        int sum = 0; // 数组元素绝对值的总和
        int numNegatives = 0; // 数组中负数的个数
        int minAbs = Integer.MAX_VALUE; // 数组中绝对值最小的元素的绝对值

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            sum += Math.abs(nums[i]); // 累加绝对值
            if (nums[i] < 0) {
                numNegatives++; // 统计负数个数
                minAbs = Math.min(minAbs, Math.abs(nums[i])); // 更新绝对值最小的元素
            }
        }

        if (numNegatives % 2 == 0) {
            // 如果负数个数为偶数，结果为所有元素绝对值的总和
            System.out.println(sum);
        } else {
            // 如果负数个数为奇数，结果为总和减去绝对值最小的元素的绝对值
            //为什么是2的意思是：一次是因为它原本就被加入到了总和中，另一次是因为我们需要将它从总和中移除，以模拟它被“配对”后的效果。
            System.out.println(sum - 2 * minAbs);
        }
    }
}




