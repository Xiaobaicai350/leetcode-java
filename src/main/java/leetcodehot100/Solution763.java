package leetcodehot100;

import java.util.ArrayList;
import java.util.List;

/*
给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
例如，字符串 "ababcc" 能够被分为 ["abab", "cc"]，但类似 ["aba", "bcc"] 或 ["ab", "ab", "cc"] 的划分是非法的。
注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
返回一个表示每个字符串片段的长度的列表。

示例 1：
输入：s = "ababcbacadefegdehijhklij"
输出：[9,7,8]
解释：
划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
每个字母最多出现在一个片段中。
像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。

示例 2：
输入：s = "eccbbbbdec"
输出：[10]
 */
/**
 * 这道题其实思路很简单，先创建一个数组用来存储每个字符最后出现的位置
 * 然后遍历数组，每一次比较end和当前字符的最后出现位置，如果如果当前的字符最后出现的位置比end大，就需要更新end，因为需要满足题意：同一字母最多出现在一个片段中
 * 而且需要判断是否到了end节点了，如果到end节点了，说明这前面的所有的最后出现位置都没end大，可以进行收获了
 */
class Solution763 {
    public List<Integer> partitionLabels(String s) {
        //初始化数组用来存储每一个字符最后出现的位置
        //比如lastPos[0] = 10,说明a最后出现的位置是10
        int[] lastPos = new int[26];
        ArrayList<Integer> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        //遍历数组，将每一个字符最后出现的位置存储到lastPos里面
        for (int i = 0; i < s.length(); i++) {
            lastPos[chars[i] - 'a'] = i;
        }
        //现在lastPos里面存储着每一个字符最后出现的位置。
        int start = 0;
        int end = 0;
        //再次遍历数组。
        for (int i = 0; i < s.length(); i++) {
            //如果当前的字符最后出现的位置比end大
            if (lastPos[chars[i] - 'a'] > end) {
                //更新end
                end = lastPos[chars[i] - 'a'];
            }
            //如果到了end节点，说明已经形成一个区间了，可以增加成结果集了
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}