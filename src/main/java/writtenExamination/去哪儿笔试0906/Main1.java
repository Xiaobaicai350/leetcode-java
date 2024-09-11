package writtenExamination.去哪儿笔试0906;

import java.util.*;


// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            List<Integer> ints = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                ints.add(in.nextInt());
            }

            //给定字符串a和b，如果a + b < b + a，那么在最终的数组中，a一定在b的前面。
            // 因此，我们根据a + b < b + a进行排序即可。
            //默认从小到大排列的
            ints.sort((x, y) -> {
                String s1 = Integer.toString(x);
                String s2 = Integer.toString(y);
                //比较两个拼接后的字符串，如果s1 + s2大于s2 + s1，则返回正数；如果相等，则返回0；如果小于，则返回负数。
                //如果s1+s2<s2+s1 返回-1 说明这个的顺序应该是s1s2
                return (s1 + s2).compareTo(s2 + s1);
            });
            // 输出结果
            for (int x : ints) {
                System.out.print(x + " ");
            }
        }
    }
}
