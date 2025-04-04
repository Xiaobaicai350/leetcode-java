package leetcodehot100;

/*
输入：strs = ["flower","flow","flight"]
输出："fl"

输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。
 */

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //保存第一个字符串的长度
        int length = strs[0].length();
        //保存一共有多少个字符串
        int count = strs.length;
        //循环第一个字符串
        for (int i = 0; i < length; i++) {
            //拿到第一个字符串的第一个字母
            char c = strs[0].charAt(i);
            //从第二个字符串开始循环
            for (int j = 1; j < count; j++) {
                //当循环到某个字符串的最后一位了||不等于的时候，就可以进行退出了
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        //到这说明是所有字符串都跟strs[0]相等，直接返回就行
        return strs[0];
    }
}