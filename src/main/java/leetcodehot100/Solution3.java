package leetcodehot100;

import java.util.HashSet;
import java.util.Set;

/**
 * 用一个set来记录目前的窗口里面都有什么字符
 * 每次窗口走的时候去set里面验证一下有没有这个字符，如果有，就需要缩小窗口，如果没有，就扩大窗口大小，并且记录比较最大值
 */
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        // 定义滑动窗口
        int left = 0;
        int right = 0;
        // 定义记录最大长度的数字
        int maxWindowLen = 0;
        // 用于存储目前的窗口里面都有什么字符
        Set<Character> set = new HashSet<>();
        while (left < s.length() && right < s.length()) {
            // 如果set中有这个字符
            if (set.contains(s.charAt(right))) {
                // 就向左缩小窗口大小,直到删除到right这个下标的字符之前出现的位置的下一位
                set.remove(s.charAt(left));
                left++;
            } else {
                // 如果set中没这个字符，说明这个字符在窗口里面是第一次出现，就加入到set中
                set.add(s.charAt(right));
                right++;

                // 计算最大长度
                int curWindowLen = right - left;
                maxWindowLen = Math.max(maxWindowLen, curWindowLen);
            }
        }
        return maxWindowLen;
    }
}