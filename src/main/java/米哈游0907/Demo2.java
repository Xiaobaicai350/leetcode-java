package 米哈游0907;

import java.util.HashMap;
import java.util.Scanner;

/*
4 13 m
0 1111 525 1031 55 0 0 722 0 430 1221 29 711
9 5 3
3 2 4
2 3 7
2 11 5
4 0 6
10 2 13
10 5 196
1 12 8
 */
public class Demo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int m = in.nextInt();
            int n = in.nextInt();
            int[] c = new int[n];
            int[] a = new int[3];
            int[] b = new int[3];
            for (int i = 0; i < n; i++) {
                c[i] = in.nextInt();
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < 3; j++) {
                    a[j] = in.nextInt();
                }
                for (int j = 0; j < 3; j++) {
                    b[j] = in.nextInt();
                }
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            //记录b[i]至少出现三次的数
            for (int i = 0; i < m; i++) {
                if (map.containsKey(b[i])) {
                    map.put(b[i], map.get(b[i]) + 1);
                } else {
                    map.put(b[i], 1);
                }
            }
            int maxCheng=0;
            int renId=0;
            //进行贪心 寻找值最大的那个
            for (Integer integer : map.keySet()) {
                Integer count = map.get(integer);
                if(count>=3&&a[integer]>maxCheng){
                    maxCheng=a[integer];
                    renId=integer;
                }
            }
            int res=0;
            for (int i = 0; i < m; i++) {
                if(b[i]==renId){
                    res+=a[i];
                }else{
                    res+=maxCheng;
                }
            }
            System.out.println(res);
        }
    }
}
