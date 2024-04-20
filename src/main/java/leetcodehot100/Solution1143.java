package leetcodehot100;

//https://leetcode.cn/problems/longest-common-subsequence/solutions/696763/zui-chang-gong-gong-zi-xu-lie-by-leetcod-y7u0/?envType=study-plan-v2&envId=top-100-liked


/*
输入：text1 = "abcde", text2 = "ace"
输出：3
解释：最长公共子序列是 "ace" ，它的长度为 3 。
 */

/*
dp[i][j]
0000
0111
0111
0122
0122
0123
 */
/**
 * 其实我感觉这道题就是看这两个字符串里面有多少相同的字符，按顺序来看，如果相同就+1
 */
class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // dp[i][j]:表示text1[0:i]和text2[0:j]的最长公共子序列长度是dp[i][j]
        int[][] dp = new int[m + 1][n + 1];

        // 双层循环遍历text1和text2
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 当text1[i] == text2[j]时，当前字符匹配，dp值加1
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    // 当text1[i] != text2[j]时，取上边或者左边的最大值
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        // 返回dp数组的最后一个值，即text1和text2的最长公共子序列长度
        return dp[m][n];
    }
}