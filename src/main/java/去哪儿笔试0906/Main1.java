package 去哪儿笔试0906;

import java.util.Arrays;
import java.util.Scanner;


// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] ints = new int[n];
            int i = 0;
            while (in.hasNextInt()) {
                ints[i] = in.nextInt();
                i++;
            }
            Arrays.sort(ints);
            System.out.print(ints[0]);
            for (int j = 1; j < ints.length; j++) {
                System.out.print(" "+ints[j]);
            }
        }
    }
}
