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
    public static void main1(String[] args) {
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

    /*
5 20
1 2 3 4 5
4 2 3 5 10
 */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        long m = Integer.parseInt(input[1]);
        int[] res1 = new int[n];
        String[] ans1 = in.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            res1[i] = Integer.parseInt(ans1[i]);
        }
        int[] res2 = new int[n];
        String[] ans2 = in.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            res2[i] = Integer.parseInt(ans2[i]);
        }
        //因为只能按顺序查找，并且前面的一定小于后面的，所以可以用二分查找
        //二分查找对应的天数，我上面的做法会超时
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (checkTrue(res1, res2, mid, m)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        //一直查找到完全，这时候l=r+1 刚刚好位于第一次>=m的情况，下面的加一因为l是下标
        System.out.println(l >= n ? -1 : (l + 1));
    }

    public static boolean checkTrue(int[] res1, int[] res2, int mid, long m) {
        int[] Ans1Copy = Arrays.copyOfRange(res1, 0, mid + 1);
        Arrays.sort(Ans1Copy);
        int[] Ans2Copy = Arrays.copyOfRange(res2, 0, mid + 1);
        Arrays.sort(Ans2Copy);
        long res = 0l;
        for (int i = mid; i >= 0; i--) {
            res += (long) Ans1Copy[i] * Ans2Copy[i];
            if (res >= m) {
                return true;
            }

        }
        return false;
    }
}
