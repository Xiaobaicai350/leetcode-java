package writtenExamination.美团0914;

import java.util.Scanner;

/*
2
1 2 3 4 2
10 2 1 4 2
 */
// a+4a+8a=13a
//10a+8a+8a=26a
//c=y*b=x*y*a
//b=x*a
public class Demo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // 注意 hasNext 和 hasNextLine 的区别
        for (int i = 0; i < n; i++) {
            int a= in.nextInt();
            int b= in.nextInt();
            int c= in.nextInt();
            int x= in.nextInt();
            int y= in.nextInt();
            if(a<x){
                System.out.println(1);
                continue;
            }
            int yitao=x+(x*y)+1;
            int zong=(b*x)+(c*x*y)+a;
            System.out.println(zong/yitao);
        }
    }
}
