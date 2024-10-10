package writtenExamination.Metaapp笔试1009;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo2 {
    public static void main(String[] args) {
        int second = first(new int[]{1, 2, 3, 4, 5});
        System.out.println(second);
    }

    /**
     * 请勿修改返回值类型
     */
    public static int[] answer(int[] x) {
        int first = first(x);
        int[] second = second(first);
        int[] third = third(second);
        return third;
    }

    public static int first(int[] ints) {
        int len = ints.length;
        if (len == 0) {
            return 4;
        } else if (len % 2 == 1) {
            if (len < 5) {
                //全加上返回
                int res = 0;
                for (int i = 0; i < len; i++) {
                    res += ints[i];
                }
                return res;
            } else {
                //取中间5个
                int helf = len / 2;//7/2=3 1+3+3
                int left = helf - 2;
                int right = helf + 2;
                int res = 0;
                for (; left <= right; left++) {
                    res += ints[left];
                }
                return res;
            }
        } else {
            //是偶数，返回4个
            if (len < 4) {
                //全加上返回
                int res = 0;
                for (int i = 0; i < len; i++) {
                    res += ints[i];
                }
                return res;
            } else {
                //取中间4个
                //1 2 3 4 5 6 7 8
                int helf = len / 2;//8/2=4 3+3
                int left = helf - 2;
                int right = helf + 1;
                int res = 0;
                for (; left <= right; left++) {
                    res += ints[left];
                }
                return res;
            }
        }
    }

    public static int[] second(int x) {
        ArrayList<Integer> list = new ArrayList<>();
        int temp = x;
        while (temp != 0) {
            int yu = temp % 10;
            list.add(yu);
            temp = temp / 10;
        }
        temp = x;
        while (temp != 0) {
            int yu = temp % 10;
            list.add(yu);
            temp = temp / 10;
        }
        int[] res = new int[list.size()];
        int flag = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            res[i] = list.get(flag);
            flag++;
        }
        return res;
    }

    public static int[] third(int[] ints) {
        int len = ints.length;
        int[] res = new int[2];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (ints[i] + ints[j] == 27) {
                    return new int[]{i, j};
                }
            }
        }
        res[0] = ints[0];
        res[1] = ints[1];
        return res;
    }
}
