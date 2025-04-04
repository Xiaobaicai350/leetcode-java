package leetcodehot100;

import java.util.ArrayList;
import java.util.List;

/*
给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
示例 1：
输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]

示例 2：
输入：s = "a"
输出：[["a"]]
 */
/**
 * 把所有子串进行分割，然后再挑选出是回文串的就行了
 */
class Solution131 {
    //用于存储当前已经找到的回文子串
    List<String> path;
    //用于存储所有的回文子串
    List<List<String>> res;

    // 回溯算法
    public List<List<String>> partition(String s) {
        path = new ArrayList<>();
        res = new ArrayList<>();
        //从字符串的起始位置开始，尝试所有可能的分割点。
        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int start) {
        if (start == s.length()) { // 如果起始位置等于s的大小，说明已经找到了一组分割方案了
            List<String> tmp = new ArrayList<>(path);
            res.add(tmp);
            return;
        }
        // 从起始位置开始，尝试所有可能的分割点
        for (int i = start; i < s.length(); i++) {
            // 判断[start, i]是否是回文子串
            String str = s.substring(start, i + 1);
            if (isPalindrome(str)) { // 是回文子串
                // 添加到path中，继续递归
                path.add(str);
                // 递归
                dfs(s, i + 1); // 寻找i+1为起始位置的子串
                path.remove(path.size() - 1); // 回溯过程，弹出本次已经添加的子串
            }
        }
    }

    /**
     * 这个函数用于验证是否是回文字符串
     *
     * @param s 用于验证的字符串
     * @return 如果是回文，就返回true，非回文，返回false
     */
    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

