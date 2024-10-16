package writtenExamination.baidu笔试1015;

import java.util.Scanner;

/*
2
1 1
4 2
 */
/*
第一个样例选择1 ，积分为 1。
第二个样例一种可行方案为1 3，积分为2 。
 */
//12345 2   1 3    2
public class Main1 {
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        while (count-- != 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            if (k < n) {
                System.out.println(k);
            } else {
                System.out.println(1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // 测试用例的数量
        while (t-- > 0) {
            long n = scanner.nextLong(); // 数组的长度
            long k = scanner.nextLong(); // 指定的位置
            // 如果k小于等于(n+1)/2，则直接输出k
            // 否则，输出n+1-k
            if (k <= (n + 1) / 2) {
                System.out.println(k);
            } else {
                System.out.println(n + 1 - k);
            }
        }
    }
}