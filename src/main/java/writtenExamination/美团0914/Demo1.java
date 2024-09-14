package writtenExamination.美团0914;

import java.util.Scanner;

public class Demo1 {
    //0 4  7
    //R***B**G
    //4 3 3
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        String string = in.nextLine();
//        char[] chars = string.toCharArray();
//        int cur = 1;
//        for (int i = 1; i < chars.length; i++) {
//            if (chars[i] == 'B') {
//                System.out.print(i + " ");
//                cur = i;
//                break;
//            } else if (chars[i] == '#') {
//                System.out.print(-1 + " ");
//                break;
//            }
//        }
//        int Blen = -1;
//        for (int i = cur; i < chars.length; i++) {
//            if (chars[i] == 'G') {
//                if (i - cur < cur) {
//                    Blen = i - cur;
//                    System.out.print(Blen + " ");
//                    break;
//                }
//            } else if (chars[i] == '#') {
//                System.out.println(cur);
//                break;
//            }
//        }
//
//        for (int i = chars.length - 2; i > 0; i--) {
//            if (chars[i] == '#') {
//                System.out.println(-1);
//                break;
//            } else if (chars[i] == 'B') {
//                System.out.println(chars.length - i - 1);
//                break;
//            }
//        }
//    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String string = in.nextLine();
        int ri = string.indexOf("R");
        int gi = string.indexOf("G");
        int bi = string.indexOf("B");
        int r = Math.min(Math.abs(ri - gi), Math.abs(ri - bi));
        System.out.print(r + " ");
        int g = Math.min(Math.abs(gi - ri), Math.abs(gi - bi));
        System.out.print(g + " ");
        int b = Math.min(Math.abs(bi - ri), Math.abs(bi - gi));
        System.out.print(b + " ");
    }
}
