package leetcodehot100;

class Solution5 {
    public String longestPalindrome(String s) {
        // 创建dp数组，dp[i][j]的含义是：字符串从第i位下标到第j位下标是否是回文串
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 初始化结果(最小的回文就是单个字符)
        // 也就是初始化字符串的第一位为结果
        String result = s.substring(0, 1);

        // 初始化对角线上的值都为true
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        //第一轮，长度为2的时候，从第一个元素往后看验证是否是回文
        for (int length = 2; length <= s.length(); length++) {
            for (int start = 0; start < s.length() - length + 1; start++) {
                int end = start + length - 1;
                // 首尾不同则不可能为回文
                if (s.charAt(start) != s.charAt(end)) {
                    continue;
                } else if (length < 3) {
                    // 长度为2的字符串首尾相同就是回文
                    dp[start][end] = true;
                } else {
                    // 状态转移方程
                    dp[start][end] = dp[start + 1][end - 1];
                }
                // 记录最大值
                if (dp[start][end] && (end - start + 1) > result.length()) {
                    result = s.substring(start, end + 1);
                }
            }
        }
        return result;
    }
}

