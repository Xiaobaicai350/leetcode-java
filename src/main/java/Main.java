import java.util.Scanner;

/*
20
6
1 6 1      5+1=6       6+5+6
3 10 2     7+2=9       9+5+6
10 12 3     2+3=5
11 12 2     1+2=3
12 15 2     3+2=5
13 18 1     5+1=6
1（9） 2（5） 5（6）
*/
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] ints = new int[m][3];
        for (int i = 0; i < m; i++) {
            ints[i][0] = in.nextInt();
            ints[i][1] = in.nextInt();
            ints[i][2] = in.nextInt();
        }
        int[] maxInts = new int[m];
        for (int i = 0; i < m; i++) {
            maxInts[i] = maxInts[i] + ints[i][2] + ints[i][1] - ints[i][0];
            boolean canFoundNext = false;
            int nextIndex = -1;
            int next = ints[i][1];
            for (int j = i + 1; j < m; j++) {
                if (ints[j][0] >= next) {
                    maxInts[i] = maxInts[i] + ints[j][2] + ints[j][1] - ints[j][0];
                    canFoundNext = true;
                    nextIndex = j;
                    break;
                }
            }
            while (canFoundNext) {
                canFoundNext = false;
                for (int k = nextIndex + 1; k < m; k++) {
                    next = ints[nextIndex][1];
                    if (ints[k][0] >= next) {
                        maxInts[i] = maxInts[i] + ints[k][2] + ints[k][1] - ints[k][0];
                        canFoundNext = true;
                        nextIndex = k;
                        break;
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < maxInts.length; i++) {
            max = Math.max(max, maxInts[i]);
        }
        System.out.println(max);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] ints = new int[m][3];
        for (int i = 0; i < m; i++) {
            ints[i][0] = in.nextInt();
            ints[i][1] = in.nextInt();
            ints[i][2] = in.nextInt();
        }
        int[] valInts=new int[m];
        int max=0;
        for (int i=0;i<m;i++){
            valInts[i]=ints[i][1]-ints[i][0]+ints[i][3];
            max=Math.max(valInts[i],max);
        }
        System.out.println(max);
    }
}