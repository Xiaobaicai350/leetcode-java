package writtenExamination.去哪儿笔试0906;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
/*
5 20
1 2 3 4 5
4 2 3 5 10
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int m = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
            }
            int res = 0;
            int cur = 0;
            boolean flag = false;
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                res = 0;
                list1.add(b[i]);
                list2.add(a[i]);
                int[] ints = new int[list1.size()];
                int[] ints1 = new int[list1.size()];
                for (int j = 0; j < ints.length; j++) {
                    ints[j] = list1.get(j);
                    ints1[j] = list2.get(j);
                }
                Arrays.sort(ints);
                Arrays.sort(ints1);
                for (int j = ints.length - 1; j >= 0; j--) {
                    cur = cur + ints[j] * ints1[j];
                    res++;
                }
                if (cur >= m) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println(res);
            } else {
                System.out.println(-1);
            }
        }

    }
}