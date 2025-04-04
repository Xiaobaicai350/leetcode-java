package leetcodehot100;

/*
示例 1：
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。

示例 2：
输入：s = "cbbd"
输出："bb"
 */
/**
 * 这道题是 一个字符串的最长回文字符串是什么
 * 其实也是暴力解法，但是对是否是回文字符串进行了优化代码
 */
class Solution5 {
    public String longestPalindrome(String s) {
        //初始化最长回文字符串，默认第一个字符
        String longestPalindrome = s.substring(0, 1);
        //字符串长度为2｜3｜4的时候
        for (int len = 2; len <= s.length(); len++) {
            //从0开始，到s.length-len+1结束
            for (int start = 0; start < s.length() - len + 1; start++) {
                int end = start + len;
                String string = s.substring(start, end);
                if (isPalindrome(string)) {
                    //如果是回文字符串
                    //记录最长的值
                    if (string.length() > longestPalindrome.length()) {
                        longestPalindrome = string;
                    }
                }
            }
        }
        return longestPalindrome;
    }
    //判断str这个字符串是否是回文字符串
    public boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        // 从两端开始比较字符，直到找到不匹配的字符或者比较完整个字符串
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
