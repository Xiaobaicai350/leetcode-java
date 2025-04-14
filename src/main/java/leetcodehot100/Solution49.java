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
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortStr = charArray.toString();
            if(map.containsKey(sortStr)){
                ArrayList<String> list = map.get(sortStr);
                list.add(str);
            }else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(sortStr,temp);
            }
        }
        List<List<String>> res = new ArrayList<>(map.values());
        return res;
    }
}