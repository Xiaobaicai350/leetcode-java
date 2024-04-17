package leetcodehot100;

import java.util.List;

/**
 * 这道题可以转换成，求装满背包s的前几位字符的方式有几种
 */
class Solution139 {
    public boolean wordBreak(String s, String[] wordDict) {
        //装满背包s的前几位字符的方式有几种
        int[] dp = new int[s.length() + 1];
        //初始化dp数组
        dp[0] = 1;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < wordDict.length; j++) {
                if (i >= wordDict[j].length()
                        &&
                        wordDict[j].equals(s.substring(i - wordDict[j].length(), i))) {
                    dp[i] += dp[i - wordDict[j].length()];
                }
            }
        }
        return dp[s.length()] > 0;
    }
}
