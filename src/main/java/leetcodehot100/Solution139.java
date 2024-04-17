package leetcodehot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 这道题可以转换成背包问题：求装满背包s的字符的方式有几种
 */
class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // dp[i]表示字符串s的前i个字符是否可以被拆分成字典中的单词
        boolean[] dp = new boolean[n + 1];
        // 空字符串可以被拆分
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                //计算出来单词的长度
                int len = word.length();
                //如果串s的下标位置比当前单词长度大，并且字符串s的前i - len个字符可以被拆分成字典中的单词 并且现在len的长度也刚好匹配，就可以重置成true
                if (i >= len && dp[i - len] && s.substring(i - len, i).equals(word)) {
                    // 如果前面的子字符串可以被拆分，并且当前位置到前一个单词的长度的子字符串正好等于一个字典中的单词，
                    // 就说明当前位置的前面子串全部可以被拆分
                    dp[i] = true;
                    break;
                }
            }
        }

        // 返回最终结果，即dp[n]，表示整个字符串s是否可以被拆分成字典中的单词
        return dp[n];
    }
}