package writtenExamination.美团0914;

import java.util.Scanner;

public class Demo1 {
    //0 4  7
    //R***B**G
    //4 3 3
    //自己写的，没考虑阻挡
    public static void main1(String[] args) {
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine(); // 读取输入的字符串
        int ri = string.indexOf("R"); // 找到字符 'R' 的索引
        int gi = string.indexOf("G"); // 找到字符 'G' 的索引
        int bi = string.indexOf("B"); // 找到字符 'B' 的索引

        // 计算 'R' 到 'G' 和 'B' 的最小距离，并输出
        int r = calculateDistance(string, ri, gi, bi, 'R');
        System.out.print(r + " ");
        // 计算 'G' 到 'R' 和 'B' 的最小距离，并输出
        int g = calculateDistance(string, gi, ri, bi, 'G');
        System.out.print(g + " ");
        // 计算 'B' 到 'R' 和 'G' 的最小距离，并输出
        int b = calculateDistance(string, bi, ri, gi, 'B');
        System.out.print(b + " ");
    }

    // 计算字符 c 到其他两个字符的最小距离
    private static int calculateDistance(String string, int ci, int i1, int i2, char c) {
        int d1 = getDistanceWithObstacles(string, ci, i1); // 计算到第一个字符的距离
        int d2 = getDistanceWithObstacles(string, ci, i2); // 计算到第二个字符的距离
        return Math.min(d1, d2); // 返回最小的距离
    }

    // 计算两个索引之间的距离，如果中间有 '#' 则返回最大值
    private static int getDistanceWithObstacles(String string, int start, int end) {
        if (start > end) { // 确保 start 小于 end
            int temp = start;
            start = end;
            end = temp;
        }
        for (int i = start + 1; i < end; i++) { // 检查 start 和 end 之间是否有 '#'
            if (string.charAt(i) == '#') {
                return Integer.MAX_VALUE; // 如果有阻挡，返回最大值
            }
        }
        return Math.abs(start - end); // 返回 start 和 end 之间的距离
    }


}
