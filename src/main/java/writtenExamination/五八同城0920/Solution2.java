package writtenExamination.五八同城0920;

public class Solution2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param str string字符串
     * @return int整型
     */
    //"abbbab" 5
    //将字符串 s 划分为两个非空子字符串的可行方案有：
    //左子字符串 = "a" 且 右子字符串 = "bbbab"，得分 = 1 + 4 = 5
    //左子字符串 = "ab" 且 右子字符串 = "bbab"，得分 = 1 + 3 = 4
    //左子字符串 = "abb" 且 右子字符串 = "bab"，得分 = 1 + 2 = 3
    //左子字符串 = "abbb" 且 右子字符串 = "ab"，得分 = 1 + 1 = 2
    //左子字符串 = "abbba" 且 右子字符串 = "b"，得分 = 2 + 1 = 3
    public int StringSplit(String str) {
        // write code here
        char[] chars = str.toCharArray();
        int maxLen = 0;
        for (int i = 1; i < chars.length; i++) {
            int aNum = 0;
            int bNum = 0;
            for (int j = 0; j < i; j++) {
                if (chars[j] == 'a') {
                    aNum++;
                }
            }
            for (int j = i; j < chars.length; j++) {
                if (chars[j] == 'b') {
                    bNum++;
                }
            }
            maxLen = Math.max(maxLen, aNum + bNum);
        }
        return maxLen;
    }
}