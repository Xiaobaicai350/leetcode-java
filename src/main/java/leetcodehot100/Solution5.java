package leetcodehot100;

/**
 * 其实也是暴力解法，但是对是否是回文字符串进行了优化代码
 */
class Solution5 {
    public String longestPalindrome(String s) {
        String longestPalindrome = s.substring(0, 1);
        for (int len = 2; len <= s.length(); len++) {
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
