package 米哈游0907;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


public class Demo3 {

}
// 注意类名必须为 米哈游0907.Main, 不要有任何 package xxx 信息
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int m = in.nextInt();
            int n = in.nextInt();
            int maxCount=0;
            int maxVal=m;
            for (int i = m; i <=n; i++) {
                int count=searchCount(i);
                if(count>=maxCount){
                    maxCount=count;
                    maxVal=i;
                }
            }
            System.out.println(maxVal);
        }
    }

    private static int searchCount(int i) {
        String s=i+"";
        int originLen = s.length();
        s=s.replace("4","");
        s = s.replace("6", "");
        int curLen = s.length();
        return originLen-curLen;

    }
}