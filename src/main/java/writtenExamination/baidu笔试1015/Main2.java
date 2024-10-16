package writtenExamination.baidu笔试1015;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
//paectc
//第一步aectcp ，第二步 actcpe，第三步accpet ，第四步accetp ，第五步accept ，第六步accept 。
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int len = str.length();
        StringBuilder builder = new StringBuilder(str);
        for (int i = 0; i < len; i++) {
            builder.append(builder.charAt(i));
            builder.deleteCharAt(i);

        }
        System.out.println(builder);
    }
}