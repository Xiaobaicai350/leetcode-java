package leetcodehot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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