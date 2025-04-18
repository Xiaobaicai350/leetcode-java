package leetcodehot100;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
给你一个字符串 s ，请你反转字符串中 单词 的顺序。
单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。

示例 1：
输入：s = "the sky is blue"
输出："blue is sky the"

示例 2：
输入：s = "  hello world  "
输出："world hello"
解释：反转后的字符串中不能存在前导空格和尾随空格。

示例 3：
输入：s = "a good   example"
输出："example good a"
解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 */
class Solution151 {
    public String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        //\\s：在正则表达式中，\s 是一个预定义字符类，表示任何空白字符，包括空格、制表符、换页符等。
        //数组转换成集合，这样才能用集合中的reverse方法
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        //翻转集合中的所有string
        Collections.reverse(wordList);
        //然后用空格进行拼接字符串
        //String.join 的主要用途是将多个字符串元素按照指定的分隔符连接成一个新的字符串
        return String.join(" ", wordList);
    }
}
