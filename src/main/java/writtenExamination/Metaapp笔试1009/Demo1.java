package writtenExamination.Metaapp笔试1009;

import java.util.ArrayList;

public class Demo1 {
    public static void main(String[] args) {

    }
    public static int[] answer(int x) {
        int[] ints = firstF(x);
        int secRes = secondF(ints);
        int[] res = thirdF(secRes);
        return res;
    }

    public static int[] firstF(int x) {
        int[] ints = new int[15];
        int cur = 70;
        for (int i = 0; i < 15; i++) {
            ints[14 - i] = cur;
            cur += x;
        }
        return ints;
    }

    public static int secondF(int[] ints) {
        int len = ints.length;
        if (len == 0) {
            return 6;
        } else if (len % 2 == 1) {
            if (len < 7) {
                //全加上返回
                int res = 0;
                for (int i = 0; i < len; i++) {
                    res += ints[i];
                }
                return res;
            } else {
                //取中间七个
                int helf = len / 2;//7/2=3 1+3+3
                int left = helf - 3;
                int right = helf + 3;
                int res = 0;
                for (; left <= right; left++) {
                    res += ints[left];
                }
                return res;
            }
        } else {
            //是偶数，返回6个
            if (len < 6) {
                //全加上返回
                int res = 0;
                for (int i = 0; i < len; i++) {
                    res += ints[i];
                }
                return res;
            } else {
                //取中间6个
                //1 2 3 4 5 6 7 8
                int helf = len / 2;//8/2=4 3+3
                int left = helf - 3;
                int right = helf + 2;
                int res = 0;
                for (; left <= right; left++) {
                    res += ints[left];
                }
                return res;
            }
        }
    }

    public static int[] thirdF(int x) {
        if (x > 100000) {
            x = 100000;
        } else if (x < 0) {
            x = -x;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (x != 0) {
            int yu = x % 7;
            list.add(yu);
            x /= 7;
        }
        int[] res = new int[list.size()];
        int flag = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            res[i] = list.get(flag);
            flag++;
        }
        return res;
    }
}
