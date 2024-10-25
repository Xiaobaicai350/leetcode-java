package writtenExamination.腾讯云智笔试1022;

import java.util.Scanner;


/*
3
3 2
5 4
10 18
 */
/*
1
2
17
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int x = in.nextInt();
            int k = in.nextInt();
            int maxVal = Integer.MIN_VALUE;
            int maxY = 0;
            for (int j = 1; j <= k; j++) {
                int temp = x ^ j;
                if (temp > maxVal) {
                    maxVal = temp;
                    maxY = j;
                }
            }
            System.out.println(maxY);
        }
    }
}