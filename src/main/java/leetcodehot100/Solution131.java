package leetcodehot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 把所有子串进行分割，然后再挑选出是回文串的就行了
 */
class Solution131 {
    List<String> path; // 放已经回文的子串
    List<List<String>> res;

    public List<List<String>> partition(String s) {
        path = new ArrayList<>();
        res = new ArrayList<>();
        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int start) {
        if (start == s.length()) { // 如果起始位置等于s的大小，说明已经找到了一组分割方案了
            List<String> tmp = new ArrayList<>(path);
            res.add(tmp);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);
            if (isPalindrome(str)) { // 是回文子串
                path.add(str);
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

