package leetcodehot100;

import java.util.ArrayList;
import java.util.List;

/*
给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。

示例 1：
输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。

示例 2：
输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
     注意，你可以重复使用字典中的单词。

示例 3：
输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false
 */
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
                //如果
                // s的下标位置比当前单词长度大（这个是后面判断条件的安全性校验），
                // 并且字符串s的前i - len个字符可以被拆分成字典中的单词
                // 并且现在len的长度也刚好匹配，就可以重置成true
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