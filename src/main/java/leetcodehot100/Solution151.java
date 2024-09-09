package leetcodehot100;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution151 {
    public String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        //翻转集合中的所有string
        Collections.reverse(wordList);
        //然后用空格进行拼接字符串
        return String.join(" ", wordList);
    }
}
