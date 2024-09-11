package writtenExamination.滴滴0907;

import java.util.Scanner;

/*
3
1 50
2 2
3 1
 */
//0 2 2
public class Main1 {
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] ints = new int[n][2];
        for (int i = 0; i < n; i++) {
            ints[i][0] = in.nextInt();
            ints[i][1] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (ints[i][0] == 1) {
                System.out.print(0 + " ");
            } else {
                int jiou = ints[i][1] % 2;
                if (jiou == 0) {//如果这个数是偶数
                    //4 4
                    int chu = ints[i][0] / 2;
                    int every = ints[i][1] / chu;
                    int res = every * (ints[i][0] - 1);
                    System.out.print(res + " ");
                } else {
                    //02030  5 5   2+2+3+3=10
                    //010 3 1
                    int chu = ints[i][0] / 2;//1
                    int every = ints[i][1] / chu;//1
                    int res=0;
                    if(ints[i][0]>3){
                        res = every * (ints[i][0] - 3)+2*(every+1);//2*3+2*3

                    }else{
                        res = every * (ints[i][0] - 1);
                    }
                    System.out.print(res + " ");
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n=sc.nextInt();
            int m=sc.nextInt();
            //一共三种情况，当n==1时只能是0，当m是2时候只能是2，除此之外只能是2m
            //其实当时写的时候就是模拟
            if(n==1){
                System.out.println(0);
            }else if(n==2){
                System.out.println(2);
            }else {
                System.out.println(2*m);
            }
        }
    }
}
