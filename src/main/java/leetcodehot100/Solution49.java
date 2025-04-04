package leetcodehot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
字母异位词 是由重新排列源单词的所有字母得到的一个新单词。

示例 1:
输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

示例 2:
输入: strs = [""]
输出: [[""]]

示例 3:
输入: strs = ["a"]
输出: [["a"]]
 */
/**
 * 这个题的思路就是，先把字符数组进行排序，然后进行比较，如果比较的结果是他们相同，就把他们归成一组
 */
class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 新建结果集
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        // 遍历字符串数组
        for (String string : strs) {
            // 把字符串转换成字符数组
            char[] charArray = string.toCharArray();
            // 把字符串进行排序
            Arrays.sort(charArray);
            // 再把字符数组转换成字符串
            String newString = String.valueOf(charArray);
            // 如果map里面没有这个字符串，说明是第一次进行添加
            if (!map.containsKey(newString)) {
                map.put(newString, new ArrayList<>());
            }
            // 这里需要注意的是，key总为排序后的新字符串，而添加到value的list中的值为旧字符串
            map.get(newString).add(string);
        }
        return new ArrayList<>(map.values());
    }
}